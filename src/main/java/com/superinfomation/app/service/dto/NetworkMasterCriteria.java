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
 * Criteria class for the {@link com.superinfomation.app.domain.NetworkMaster} entity. This class is used
 * in {@link com.superinfomation.app.web.rest.NetworkMasterResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /network-masters?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class NetworkMasterCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter networkCode;

    private StringFilter networkName;

    private StringFilter contactPerson;

    private StringFilter contactNumber;

    private StringFilter address;

    private StringFilter website;

    private StringFilter email;

    private LongFilter cityMasterId;

    public NetworkMasterCriteria() {
    }

    public NetworkMasterCriteria(NetworkMasterCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.networkCode = other.networkCode == null ? null : other.networkCode.copy();
        this.networkName = other.networkName == null ? null : other.networkName.copy();
        this.contactPerson = other.contactPerson == null ? null : other.contactPerson.copy();
        this.contactNumber = other.contactNumber == null ? null : other.contactNumber.copy();
        this.address = other.address == null ? null : other.address.copy();
        this.website = other.website == null ? null : other.website.copy();
        this.email = other.email == null ? null : other.email.copy();
        this.cityMasterId = other.cityMasterId == null ? null : other.cityMasterId.copy();
    }

    @Override
    public NetworkMasterCriteria copy() {
        return new NetworkMasterCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNetworkCode() {
        return networkCode;
    }

    public void setNetworkCode(StringFilter networkCode) {
        this.networkCode = networkCode;
    }

    public StringFilter getNetworkName() {
        return networkName;
    }

    public void setNetworkName(StringFilter networkName) {
        this.networkName = networkName;
    }

    public StringFilter getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(StringFilter contactPerson) {
        this.contactPerson = contactPerson;
    }

    public StringFilter getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(StringFilter contactNumber) {
        this.contactNumber = contactNumber;
    }

    public StringFilter getAddress() {
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public StringFilter getWebsite() {
        return website;
    }

    public void setWebsite(StringFilter website) {
        this.website = website;
    }

    public StringFilter getEmail() {
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
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
        final NetworkMasterCriteria that = (NetworkMasterCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(networkCode, that.networkCode) &&
            Objects.equals(networkName, that.networkName) &&
            Objects.equals(contactPerson, that.contactPerson) &&
            Objects.equals(contactNumber, that.contactNumber) &&
            Objects.equals(address, that.address) &&
            Objects.equals(website, that.website) &&
            Objects.equals(email, that.email) &&
            Objects.equals(cityMasterId, that.cityMasterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        networkCode,
        networkName,
        contactPerson,
        contactNumber,
        address,
        website,
        email,
        cityMasterId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NetworkMasterCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (networkCode != null ? "networkCode=" + networkCode + ", " : "") +
                (networkName != null ? "networkName=" + networkName + ", " : "") +
                (contactPerson != null ? "contactPerson=" + contactPerson + ", " : "") +
                (contactNumber != null ? "contactNumber=" + contactNumber + ", " : "") +
                (address != null ? "address=" + address + ", " : "") +
                (website != null ? "website=" + website + ", " : "") +
                (email != null ? "email=" + email + ", " : "") +
                (cityMasterId != null ? "cityMasterId=" + cityMasterId + ", " : "") +
            "}";
    }

}
