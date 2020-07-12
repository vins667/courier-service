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
 * Criteria class for the {@link com.superinfomation.app.domain.CompanyMaster} entity. This class is used
 * in {@link com.superinfomation.app.web.rest.CompanyMasterResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /company-masters?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CompanyMasterCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter companyName;

    private StringFilter address;

    private LongFilter country;

    private LongFilter state;

    private LongFilter city;

    private StringFilter pinCode;

    private StringFilter mdName;

    private StringFilter mdContactNo;

    private StringFilter mdEmailId;

    private StringFilter panNumber;

    private StringFilter webSiteUrl;

    private StringFilter tinNumber;

    private StringFilter gstNumber;

    private LongFilter stateMasterId;

    private LongFilter countryMasterId;

    private LongFilter cityMasterId;

    public CompanyMasterCriteria() {
    }

    public CompanyMasterCriteria(CompanyMasterCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.companyName = other.companyName == null ? null : other.companyName.copy();
        this.address = other.address == null ? null : other.address.copy();
        this.country = other.country == null ? null : other.country.copy();
        this.state = other.state == null ? null : other.state.copy();
        this.city = other.city == null ? null : other.city.copy();
        this.pinCode = other.pinCode == null ? null : other.pinCode.copy();
        this.mdName = other.mdName == null ? null : other.mdName.copy();
        this.mdContactNo = other.mdContactNo == null ? null : other.mdContactNo.copy();
        this.mdEmailId = other.mdEmailId == null ? null : other.mdEmailId.copy();
        this.panNumber = other.panNumber == null ? null : other.panNumber.copy();
        this.webSiteUrl = other.webSiteUrl == null ? null : other.webSiteUrl.copy();
        this.tinNumber = other.tinNumber == null ? null : other.tinNumber.copy();
        this.gstNumber = other.gstNumber == null ? null : other.gstNumber.copy();
        this.stateMasterId = other.stateMasterId == null ? null : other.stateMasterId.copy();
        this.countryMasterId = other.countryMasterId == null ? null : other.countryMasterId.copy();
        this.cityMasterId = other.cityMasterId == null ? null : other.cityMasterId.copy();
    }

    @Override
    public CompanyMasterCriteria copy() {
        return new CompanyMasterCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getCompanyName() {
        return companyName;
    }

    public void setCompanyName(StringFilter companyName) {
        this.companyName = companyName;
    }

    public StringFilter getAddress() {
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public LongFilter getCountry() {
        return country;
    }

    public void setCountry(LongFilter country) {
        this.country = country;
    }

    public LongFilter getState() {
        return state;
    }

    public void setState(LongFilter state) {
        this.state = state;
    }

    public LongFilter getCity() {
        return city;
    }

    public void setCity(LongFilter city) {
        this.city = city;
    }

    public StringFilter getPinCode() {
        return pinCode;
    }

    public void setPinCode(StringFilter pinCode) {
        this.pinCode = pinCode;
    }

    public StringFilter getMdName() {
        return mdName;
    }

    public void setMdName(StringFilter mdName) {
        this.mdName = mdName;
    }

    public StringFilter getMdContactNo() {
        return mdContactNo;
    }

    public void setMdContactNo(StringFilter mdContactNo) {
        this.mdContactNo = mdContactNo;
    }

    public StringFilter getMdEmailId() {
        return mdEmailId;
    }

    public void setMdEmailId(StringFilter mdEmailId) {
        this.mdEmailId = mdEmailId;
    }

    public StringFilter getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(StringFilter panNumber) {
        this.panNumber = panNumber;
    }

    public StringFilter getWebSiteUrl() {
        return webSiteUrl;
    }

    public void setWebSiteUrl(StringFilter webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }

    public StringFilter getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(StringFilter tinNumber) {
        this.tinNumber = tinNumber;
    }

    public StringFilter getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(StringFilter gstNumber) {
        this.gstNumber = gstNumber;
    }

    public LongFilter getStateMasterId() {
        return stateMasterId;
    }

    public void setStateMasterId(LongFilter stateMasterId) {
        this.stateMasterId = stateMasterId;
    }

    public LongFilter getCountryMasterId() {
        return countryMasterId;
    }

    public void setCountryMasterId(LongFilter countryMasterId) {
        this.countryMasterId = countryMasterId;
    }

    public LongFilter getCityMasterId() {
        return cityMasterId;
    }

    public void setCityMasterId(LongFilter cityMasterId) {
        this.cityMasterId = cityMasterId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CompanyMasterCriteria that = (CompanyMasterCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(companyName, that.companyName) &&
            Objects.equals(address, that.address) &&
            Objects.equals(country, that.country) &&
            Objects.equals(state, that.state) &&
            Objects.equals(city, that.city) &&
            Objects.equals(pinCode, that.pinCode) &&
            Objects.equals(mdName, that.mdName) &&
            Objects.equals(mdContactNo, that.mdContactNo) &&
            Objects.equals(mdEmailId, that.mdEmailId) &&
            Objects.equals(panNumber, that.panNumber) &&
            Objects.equals(webSiteUrl, that.webSiteUrl) &&
            Objects.equals(tinNumber, that.tinNumber) &&
            Objects.equals(gstNumber, that.gstNumber) &&
            Objects.equals(stateMasterId, that.stateMasterId) &&
            Objects.equals(countryMasterId, that.countryMasterId) &&
            Objects.equals(cityMasterId, that.cityMasterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        companyName,
        address,
        country,
        state,
        city,
        pinCode,
        mdName,
        mdContactNo,
        mdEmailId,
        panNumber,
        webSiteUrl,
        tinNumber,
        gstNumber,
        stateMasterId,
        countryMasterId,
        cityMasterId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CompanyMasterCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (companyName != null ? "companyName=" + companyName + ", " : "") +
                (address != null ? "address=" + address + ", " : "") +
                (country != null ? "country=" + country + ", " : "") +
                (state != null ? "state=" + state + ", " : "") +
                (city != null ? "city=" + city + ", " : "") +
                (pinCode != null ? "pinCode=" + pinCode + ", " : "") +
                (mdName != null ? "mdName=" + mdName + ", " : "") +
                (mdContactNo != null ? "mdContactNo=" + mdContactNo + ", " : "") +
                (mdEmailId != null ? "mdEmailId=" + mdEmailId + ", " : "") +
                (panNumber != null ? "panNumber=" + panNumber + ", " : "") +
                (webSiteUrl != null ? "webSiteUrl=" + webSiteUrl + ", " : "") +
                (tinNumber != null ? "tinNumber=" + tinNumber + ", " : "") +
                (gstNumber != null ? "gstNumber=" + gstNumber + ", " : "") +
                (stateMasterId != null ? "stateMasterId=" + stateMasterId + ", " : "") +
                (countryMasterId != null ? "countryMasterId=" + countryMasterId + ", " : "") +
                (cityMasterId != null ? "cityMasterId=" + cityMasterId + ", " : "") +
            "}";
    }

}
