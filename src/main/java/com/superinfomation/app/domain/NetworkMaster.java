package com.superinfomation.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * A NetworkMaster.
 */
@Entity
@Table(name = "network_master")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "networkmaster")
public class NetworkMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="networkMasterSeq", sequenceName="network_master_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="networkMasterSeq")
    private Long id;

    @NotNull
    @Size(min = 2, max = 10)
    @Column(name = "network_code", length = 10, nullable = false)
    private String networkCode;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "network_name", length = 20, nullable = false)
    private String networkName;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "contact_person", length = 20, nullable = false)
    private String contactPerson;

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "contact_number", length = 10, nullable = false)
    private String contactNumber;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Column(name = "website", nullable = false)
    private String website;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "networkMasters", allowSetters = true)
    private CityMaster cityMaster;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNetworkCode() {
        return networkCode;
    }

    public NetworkMaster networkCode(String networkCode) {
        this.networkCode = networkCode;
        return this;
    }

    public void setNetworkCode(String networkCode) {
        this.networkCode = networkCode;
    }

    public String getNetworkName() {
        return networkName;
    }

    public NetworkMaster networkName(String networkName) {
        this.networkName = networkName;
        return this;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public NetworkMaster contactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public NetworkMaster contactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public NetworkMaster address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public NetworkMaster website(String website) {
        this.website = website;
        return this;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public NetworkMaster email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CityMaster getCityMaster() {
        return cityMaster;
    }

    public NetworkMaster cityMaster(CityMaster cityMaster) {
        this.cityMaster = cityMaster;
        return this;
    }

    public void setCityMaster(CityMaster cityMaster) {
        this.cityMaster = cityMaster;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NetworkMaster)) {
            return false;
        }
        return id != null && id.equals(((NetworkMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NetworkMaster{" +
            "id=" + getId() +
            ", networkCode='" + getNetworkCode() + "'" +
            ", networkName='" + getNetworkName() + "'" +
            ", contactPerson='" + getContactPerson() + "'" +
            ", contactNumber='" + getContactNumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", website='" + getWebsite() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}
