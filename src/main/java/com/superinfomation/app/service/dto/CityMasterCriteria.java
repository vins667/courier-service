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
 * Criteria class for the {@link com.superinfomation.app.domain.CityMaster} entity. This class is used
 * in {@link com.superinfomation.app.web.rest.CityMasterResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /city-masters?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CityMasterCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter code;

    private StringFilter cityName;

    private StringFilter pinCode;

    private LongFilter stateMasterId;

    private LongFilter cityMasterId;

    public CityMasterCriteria() {
    }

    public CityMasterCriteria(CityMasterCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.code = other.code == null ? null : other.code.copy();
        this.cityName = other.cityName == null ? null : other.cityName.copy();
        this.pinCode = other.pinCode == null ? null : other.pinCode.copy();
        this.stateMasterId = other.stateMasterId == null ? null : other.stateMasterId.copy();
        this.cityMasterId = other.cityMasterId == null ? null : other.cityMasterId.copy();
    }

    @Override
    public CityMasterCriteria copy() {
        return new CityMasterCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getCode() {
        return code;
    }

    public void setCode(StringFilter code) {
        this.code = code;
    }

    public StringFilter getCityName() {
        return cityName;
    }

    public void setCityName(StringFilter cityName) {
        this.cityName = cityName;
    }

    public StringFilter getPinCode() {
        return pinCode;
    }

    public void setPinCode(StringFilter pinCode) {
        this.pinCode = pinCode;
    }

    public LongFilter getStateMasterId() {
        return stateMasterId;
    }

    public void setStateMasterId(LongFilter stateMasterId) {
        this.stateMasterId = stateMasterId;
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
        final CityMasterCriteria that = (CityMasterCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(code, that.code) &&
            Objects.equals(cityName, that.cityName) &&
            Objects.equals(pinCode, that.pinCode) &&
            Objects.equals(stateMasterId, that.stateMasterId) &&
            Objects.equals(cityMasterId, that.cityMasterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        code,
        cityName,
        pinCode,
        stateMasterId,
        cityMasterId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CityMasterCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (code != null ? "code=" + code + ", " : "") +
                (cityName != null ? "cityName=" + cityName + ", " : "") +
                (pinCode != null ? "pinCode=" + pinCode + ", " : "") +
                (stateMasterId != null ? "stateMasterId=" + stateMasterId + ", " : "") +
                (cityMasterId != null ? "cityMasterId=" + cityMasterId + ", " : "") +
            "}";
    }

}
