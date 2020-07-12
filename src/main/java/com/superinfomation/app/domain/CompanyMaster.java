package com.superinfomation.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * A CompanyMaster.
 */
@Entity
@Table(name = "company_master")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "companymaster")
public class CompanyMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="companyMasterSeq", sequenceName="company_master_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="companyMasterSeq")
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "company_name", length = 50, nullable = false)
    private String companyName;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "address", length = 30, nullable = false)
    private String address;

    @NotNull
    @Size(min = 6, max = 9)
    @Column(name = "pin_code", length = 9, nullable = false)
    private String pinCode;

    @NotNull
    @Column(name = "md_name", nullable = false)
    private String mdName;

    @NotNull
    @Column(name = "md_contact_no", nullable = false)
    private String mdContactNo;

    @Column(name = "md_email_id", unique = true)
    private String mdEmailId;

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "pan_number", length = 10, nullable = false)
    private String panNumber;

    @NotNull
    @Column(name = "web_site_url", nullable = false)
    private String webSiteUrl;

    @NotNull
    @Column(name = "tin_number", nullable = false)
    private String tinNumber;

    @NotNull
    @Size(min = 15, max = 15)
    @Column(name = "gst_number", length = 15, nullable = false)
    private String gstNumber;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "companyMasters", allowSetters = true)
    @JoinColumn(name="state_master_id")
    private StateMaster stateMaster;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "companyMasters", allowSetters = true)
    @JoinColumn(name="country_master_id")
    private CountryMaster countryMaster;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "companyMasters", allowSetters = true)
    @JoinColumn(name="city_master_id")
    private CityMaster cityMaster;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CompanyMaster companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public CompanyMaster address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

   

    public String getPinCode() {
        return pinCode;
    }

    public CompanyMaster pinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getMdName() {
        return mdName;
    }

    public CompanyMaster mdName(String mdName) {
        this.mdName = mdName;
        return this;
    }

    public void setMdName(String mdName) {
        this.mdName = mdName;
    }

    public String getMdContactNo() {
        return mdContactNo;
    }

    public CompanyMaster mdContactNo(String mdContactNo) {
        this.mdContactNo = mdContactNo;
        return this;
    }

    public void setMdContactNo(String mdContactNo) {
        this.mdContactNo = mdContactNo;
    }

    public String getMdEmailId() {
        return mdEmailId;
    }

    public CompanyMaster mdEmailId(String mdEmailId) {
        this.mdEmailId = mdEmailId;
        return this;
    }

    public void setMdEmailId(String mdEmailId) {
        this.mdEmailId = mdEmailId;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public CompanyMaster panNumber(String panNumber) {
        this.panNumber = panNumber;
        return this;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public CompanyMaster webSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
        return this;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public CompanyMaster tinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
        return this;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public CompanyMaster gstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
        return this;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public StateMaster getStateMaster() {
        return stateMaster;
    }

    public CompanyMaster stateMaster(StateMaster stateMaster) {
        this.stateMaster = stateMaster;
        return this;
    }

    public void setStateMaster(StateMaster stateMaster) {
        this.stateMaster = stateMaster;
    }

    public CountryMaster getCountryMaster() {
        return countryMaster;
    }

    public CompanyMaster countryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
        return this;
    }

    public void setCountryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
    }

    public CityMaster getCityMaster() {
        return cityMaster;
    }

    public CompanyMaster cityMaster(CityMaster cityMaster) {
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
        if (!(o instanceof CompanyMaster)) {
            return false;
        }
        return id != null && id.equals(((CompanyMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CompanyMaster{" +
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
            "}";
    }
}
