package com.superinfomation.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A CityMaster.
 */
@Entity
@Table(name = "city_master")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "citymaster")
public class CityMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="cityMasterSeq", sequenceName="city_master_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="cityMasterSeq")

    private Long id;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "city_name", length = 20, nullable = false)
    private String cityName;

    @NotNull
    @Size(min = 6, max = 9)
    @Column(name = "pin_code", length = 9, nullable = false)
    private String pinCode;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "cityMasters", allowSetters = true)
    @JoinColumn(name="state_master_id")
    private StateMaster stateMaster;

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public CityMaster code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCityName() {
        return cityName;
    }

    public CityMaster cityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public CityMaster pinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public StateMaster getStateMaster() {
        return stateMaster;
    }

    public CityMaster stateMaster(StateMaster stateMaster) {
        this.stateMaster = stateMaster;
        return this;
    }

    public void setStateMaster(StateMaster stateMaster) {
        this.stateMaster = stateMaster;
    }

   

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CityMaster)) {
            return false;
        }
        return id != null && id.equals(((CityMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CityMaster{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", cityName='" + getCityName() + "'" +
            ", pinCode='" + getPinCode() + "'" +
            "}";
    }
}
