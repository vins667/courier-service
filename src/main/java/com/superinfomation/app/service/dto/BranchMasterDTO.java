package com.superinfomation.app.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.superinfomation.app.domain.BranchMaster} entity.
 */
public class BranchMasterDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    private String branchName;

    @NotNull
    @Size(min = 2, max = 30)
    private String managerName;

    @NotNull
    @Size(min = 6, max = 9)
    private String pinCode;

    @NotNull
    private String address;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 10, max = 10)
    private String mobile;


    private Long companyMasterId;

    private String companyMasterCompanyName;

    private Long countryMasterId;

    private String countryMasterCountryName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getCompanyMasterId() {
        return companyMasterId;
    }

    public void setCompanyMasterId(Long companyMasterId) {
        this.companyMasterId = companyMasterId;
    }

    public String getCompanyMasterCompanyName() {
        return companyMasterCompanyName;
    }

    public void setCompanyMasterCompanyName(String companyMasterCompanyName) {
        this.companyMasterCompanyName = companyMasterCompanyName;
    }

    public Long getCountryMasterId() {
        return countryMasterId;
    }

    public void setCountryMasterId(Long countryMasterId) {
        this.countryMasterId = countryMasterId;
    }

    public String getCountryMasterCountryName() {
        return countryMasterCountryName;
    }

    public void setCountryMasterCountryName(String countryMasterCountryName) {
        this.countryMasterCountryName = countryMasterCountryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BranchMasterDTO)) {
            return false;
        }

        return id != null && id.equals(((BranchMasterDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BranchMasterDTO{" +
            "id=" + getId() +
            ", branchName='" + getBranchName() + "'" +
            ", managerName='" + getManagerName() + "'" +
            ", pinCode='" + getPinCode() + "'" +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", companyMasterId=" + getCompanyMasterId() +
            ", companyMasterCompanyName='" + getCompanyMasterCompanyName() + "'" +
            ", countryMasterId=" + getCountryMasterId() +
            ", countryMasterCountryName='" + getCountryMasterCountryName() + "'" +
            "}";
    }
}
