package com.superinfomation.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * A StateMaster.
 */
@Entity
@Table(name = "state_master")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "statemaster")
public class StateMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="stateMasterSeq", sequenceName="state_master_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="stateMasterSeq")
    private Long id;

    @NotNull
    @Size(min = 2, max = 5)
    @Column(name = "code", length = 5, nullable = false)
    private String code;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "state_name", length = 20, nullable = false)
    private String stateName;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "stateMasters", allowSetters = true)
    private CountryMaster countryMaster;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public StateMaster code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStateName() {
        return stateName;
    }

    public StateMaster stateName(String stateName) {
        this.stateName = stateName;
        return this;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public CountryMaster getCountryMaster() {
        return countryMaster;
    }

    public StateMaster countryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
        return this;
    }

    public void setCountryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StateMaster)) {
            return false;
        }
        return id != null && id.equals(((StateMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StateMaster{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", stateName='" + getStateName() + "'" +
            "}";
    }
}
