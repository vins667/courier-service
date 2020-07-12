package com.superinfomation.app.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.superinfomation.app.domain.NetworkMaster} entity.
 */
public class NetworkMasterDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 10)
    private String networkCode;

    @NotNull
    @Size(min = 2, max = 20)
    private String networkName;

    @NotNull
    @Size(min = 2, max = 20)
    private String contactPerson;

    @NotNull
    @Size(min = 10, max = 10)
    private String contactNumber;

    @NotNull
    private String address;

    @NotNull
    private String website;

    @NotNull
    private String email;


    private Long cityMasterId;

    private String cityMasterCityName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNetworkCode() {
        return networkCode;
    }

    public void setNetworkCode(String networkCode) {
        this.networkCode = networkCode;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCityMasterId() {
        return cityMasterId;
    }

    public void setCityMasterId(Long cityMasterId) {
        this.cityMasterId = cityMasterId;
    }

    public String getCityMasterCityName() {
        return cityMasterCityName;
    }

    public void setCityMasterCityName(String cityMasterCityName) {
        this.cityMasterCityName = cityMasterCityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NetworkMasterDTO)) {
            return false;
        }

        return id != null && id.equals(((NetworkMasterDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NetworkMasterDTO{" +
            "id=" + getId() +
            ", networkCode='" + getNetworkCode() + "'" +
            ", networkName='" + getNetworkName() + "'" +
            ", contactPerson='" + getContactPerson() + "'" +
            ", contactNumber='" + getContactNumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", website='" + getWebsite() + "'" +
            ", email='" + getEmail() + "'" +
            ", cityMasterId=" + getCityMasterId() +
            ", cityMasterCityName='" + getCityMasterCityName() + "'" +
            "}";
    }
}
