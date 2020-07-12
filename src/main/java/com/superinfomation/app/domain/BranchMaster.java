package com.superinfomation.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * A BranchMaster.
 */
@Entity
@Table(name = "branch_master")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "branchmaster")
public class BranchMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="branchMasterSeq", sequenceName="branch_master_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="branchMasterSeq")
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "branch_name", length = 30, nullable = false)
    private String branchName;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "manager_name", length = 30, nullable = false)
    private String managerName;

    @NotNull
    @Size(min = 6, max = 9)
    @Column(name = "pin_code", length = 9, nullable = false)
    private String pinCode;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "mobile", length = 10, nullable = false)
    private String mobile;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "branchMasters", allowSetters = true)
    @JoinColumn(name="company_master_id")
    private CompanyMaster companyMaster;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(name="country_master_id")
    private CountryMaster countryMaster;
    
    @NotNull
    @Column(name="state_master_id")
    private Long  stateMasterId;
    
    @NotNull
    @Column(name="city_master_id")
    private Long cityMasterId;
    

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public BranchMaster branchName(String branchName) {
        this.branchName = branchName;
        return this;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getManagerName() {
        return managerName;
    }

    public BranchMaster managerName(String managerName) {
        this.managerName = managerName;
        return this;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public BranchMaster pinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getAddress() {
        return address;
    }

    public BranchMaster address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public BranchMaster email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public BranchMaster mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public CompanyMaster getCompanyMaster() {
        return companyMaster;
    }

    public BranchMaster companyMaster(CompanyMaster companyMaster) {
        this.companyMaster = companyMaster;
        return this;
    }

    public void setCompanyMaster(CompanyMaster companyMaster) {
        this.companyMaster = companyMaster;
    }

    public CountryMaster getCountryMaster() {
        return countryMaster;
    }

    public BranchMaster countryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
        return this;
    }

    public void setCountryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    public Long getStateMasterId() {
		return stateMasterId;
	}

	public void setStateMasterId(Long stateMasterId) {
		this.stateMasterId = stateMasterId;
	}

	public Long getCityMasterId() {
		return cityMasterId;
	}

	public void setCityMasterId(Long cityMasterId) {
		this.cityMasterId = cityMasterId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BranchMaster)) {
            return false;
        }
        return id != null && id.equals(((BranchMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
	public String toString() {
		return "BranchMaster [id=" + id + ", branchName=" + branchName + ", managerName=" + managerName + ", pinCode="
				+ pinCode + ", address=" + address + ", email=" + email + ", mobile=" + mobile + ", companyMaster="
				+ companyMaster + ", countryMaster=" + countryMaster + ", stateMasterId=" + stateMasterId
				+ ", cityMasterId=" + cityMasterId + "]";
	}
}
