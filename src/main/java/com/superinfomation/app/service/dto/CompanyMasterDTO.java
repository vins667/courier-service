package com.superinfomation.app.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.superinfomation.app.domain.CompanyMaster} entity.
 */
public class CompanyMasterDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String companyName;

    @NotNull
    @Size(min = 2, max = 30)
    private String address;

    

    @NotNull
    @Size(min = 6, max = 9)
    private String pinCode;

    @NotNull
    private String mdName;

    @NotNull
    private String mdContactNo;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String mdEmailId;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String panNumber;

    @NotNull
    @Pattern(regexp = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+(\\.[a-z]{2,}){1,3}(#?\\/?[a-zA-Z0-9#]+)*\\/?(\\?[a-zA-Z0-9-_]+=[a-zA-Z0-9-%]+&?)?$")
    private String webSiteUrl;

    @NotNull
    private String tinNumber;

    @NotNull
    @Size(min = 15, max = 15)
    @Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$")
    private String gstNumber;


    private Long stateMasterId;

    private String stateMasterStateName;

    private Long countryMasterId;

    private String countryMasterCountryName;

    private Long cityMasterId;

    private String cityMasterCityName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

  
    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getMdName() {
        return mdName;
    }

    public void setMdName(String mdName) {
        this.mdName = mdName;
    }

    public String getMdContactNo() {
        return mdContactNo;
    }

    public void setMdContactNo(String mdContactNo) {
        this.mdContactNo = mdContactNo;
    }

    public String getMdEmailId() {
        return mdEmailId;
    }

    public void setMdEmailId(String mdEmailId) {
        this.mdEmailId = mdEmailId;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public Long getStateMasterId() {
        return stateMasterId;
    }

    public void setStateMasterId(Long stateMasterId) {
        this.stateMasterId = stateMasterId;
    }

    public String getStateMasterStateName() {
        return stateMasterStateName;
    }

    public void setStateMasterStateName(String stateMasterStateName) {
        this.stateMasterStateName = stateMasterStateName;
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
        if (!(o instanceof CompanyMasterDTO)) {
            return false;
        }

        return id != null && id.equals(((CompanyMasterDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CompanyMasterDTO{" +
            "id=" + getId() +
            ", companyName='" + getCompanyName() + "'" +
            ", address='" + getAddress() + "'" +
            ", pinCode='" + getPinCode() + "'" +
            ", mdName='" + getMdName() + "'" +
            ", mdContactNo='" + getMdContactNo() + "'" +
            ", mdEmailId='" + getMdEmailId() + "'" +
            ", panNumber='" + getPanNumber() + "'" +
            ", webSiteUrl='" + getWebSiteUrl() + "'" +
            ", tinNumber='" + getTinNumber() + "'" +
            ", gstNumber='" + getGstNumber() + "'" +
            ", stateMasterId=" + getStateMasterId() +
            ", stateMasterStateName='" + getStateMasterStateName() + "'" +
            ", countryMasterId=" + getCountryMasterId() +
            ", countryMasterCountryName='" + getCountryMasterCountryName() + "'" +
            ", cityMasterId=" + getCityMasterId() +
            ", cityMasterCityName='" + getCityMasterCityName() + "'" +
            "}";
    }
}
