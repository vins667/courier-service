package com.superinfomation.app.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.superinfomation.app.domain.BranchMaster} entity. This class is used
 * in {@link com.superinfomation.app.web.rest.BranchMasterResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /branch-masters?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BranchMasterCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter branchName;

    private StringFilter managerName;

    private StringFilter pinCode;

    private StringFilter address;

    private StringFilter email;

    private StringFilter mobile;

    private LongFilter companyMasterId;

    private LongFilter countryMasterId;

    public BranchMasterCriteria() {
    }

    public BranchMasterCriteria(BranchMasterCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.branchName = other.branchName == null ? null : other.branchName.copy();
        this.managerName = other.managerName == null ? null : other.managerName.copy();
        this.pinCode = other.pinCode == null ? null : other.pinCode.copy();
        this.address = other.address == null ? null : other.address.copy();
        this.email = other.email == null ? null : other.email.copy();
        this.mobile = other.mobile == null ? null : other.mobile.copy();
        this.companyMasterId = other.companyMasterId == null ? null : other.companyMasterId.copy();
        this.countryMasterId = other.countryMasterId == null ? null : other.countryMasterId.copy();
    }

    @Override
    public BranchMasterCriteria copy() {
        return new BranchMasterCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getBranchName() {
        return branchName;
    }

    public void setBranchName(StringFilter branchName) {
        this.branchName = branchName;
    }

    public StringFilter getManagerName() {
        return managerName;
    }

    public void setManagerName(StringFilter managerName) {
        this.managerName = managerName;
    }

    public StringFilter getPinCode() {
        return pinCode;
    }

    public void setPinCode(StringFilter pinCode) {
        this.pinCode = pinCode;
    }

    public StringFilter getAddress() {
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public StringFilter getEmail() {
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public StringFilter getMobile() {
        return mobile;
    }

    public void setMobile(StringFilter mobile) {
        this.mobile = mobile;
    }

    public LongFilter getCompanyMasterId() {
        return companyMasterId;
    }

    public void setCompanyMasterId(LongFilter companyMasterId) {
        this.companyMasterId = companyMasterId;
    }

    public LongFilter getCountryMasterId() {
        return countryMasterId;
    }

    public void setCountryMasterId(LongFilter countryMasterId) {
        this.countryMasterId = countryMasterId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BranchMasterCriteria that = (BranchMasterCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(branchName, that.branchName) &&
            Objects.equals(managerName, that.managerName) &&
            Objects.equals(pinCode, that.pinCode) &&
            Objects.equals(address, that.address) &&
            Objects.equals(email, that.email) &&
            Objects.equals(mobile, that.mobile) &&
            Objects.equals(companyMasterId, that.companyMasterId) &&
            Objects.equals(countryMasterId, that.countryMasterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        branchName,
        managerName,
        pinCode,
        address,
        email,
        mobile,
        companyMasterId,
        countryMasterId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BranchMasterCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (branchName != null ? "branchName=" + branchName + ", " : "") +
                (managerName != null ? "managerName=" + managerName + ", " : "") +
                (pinCode != null ? "pinCode=" + pinCode + ", " : "") +
                (address != null ? "address=" + address + ", " : "") +
                (email != null ? "email=" + email + ", " : "") +
                (mobile != null ? "mobile=" + mobile + ", " : "") +
                (companyMasterId != null ? "companyMasterId=" + companyMasterId + ", " : "") +
                (countryMasterId != null ? "countryMasterId=" + countryMasterId + ", " : "") +
            "}";
    }

}
