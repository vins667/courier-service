package com.superinfomation.app.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A CountryMaster.
 */
@Entity
@Table(name = "country_master")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "countrymaster")
public class CountryMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="countryMasterSeq", sequenceName="country_master_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="countryMasterSeq")
    private Long id;

    @NotNull
    @Size(min = 2, max = 3)
    @Column(name = "code", length = 3, nullable = false)
    private String code;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "country_name", length = 20, nullable = false)
    private String countryName;

    @OneToMany(mappedBy = "countryMaster", fetch = FetchType.LAZY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<StateMaster> stateMaster;
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public CountryMaster code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryName() {
        return countryName;
    }

    public CountryMaster countryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CountryMaster)) {
            return false;
        }
        return id != null && id.equals(((CountryMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CountryMaster{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", countryName='" + getCountryName() + "'" +
            "}";
    }
}
