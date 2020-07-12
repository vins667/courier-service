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
 * Criteria class for the {@link com.superinfomation.app.domain.StandardTariff} entity. This class is used
 * in {@link com.superinfomation.app.web.rest.StandardTariffResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /standard-tariffs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class StandardTariffCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private DoubleFilter fromWeight;

    private DoubleFilter toWeight;

    private StringFilter dox;

    private StringFilter nDox;

    private LongFilter networkMasterId;

    private LongFilter serviceMasterId;

    private LongFilter cityMasterId;

    private LongFilter locationWiseId;

    public StandardTariffCriteria() {
    }

    public StandardTariffCriteria(StandardTariffCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.fromWeight = other.fromWeight == null ? null : other.fromWeight.copy();
        this.toWeight = other.toWeight == null ? null : other.toWeight.copy();
        this.dox = other.dox == null ? null : other.dox.copy();
        this.nDox = other.nDox == null ? null : other.nDox.copy();
        this.networkMasterId = other.networkMasterId == null ? null : other.networkMasterId.copy();
        this.serviceMasterId = other.serviceMasterId == null ? null : other.serviceMasterId.copy();
        this.cityMasterId = other.cityMasterId == null ? null : other.cityMasterId.copy();
        this.locationWiseId = other.locationWiseId == null ? null : other.locationWiseId.copy();
    }

    @Override
    public StandardTariffCriteria copy() {
        return new StandardTariffCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public DoubleFilter getFromWeight() {
        return fromWeight;
    }

    public void setFromWeight(DoubleFilter fromWeight) {
        this.fromWeight = fromWeight;
    }

    public DoubleFilter getToWeight() {
        return toWeight;
    }

    public void setToWeight(DoubleFilter toWeight) {
        this.toWeight = toWeight;
    }

    public StringFilter getDox() {
        return dox;
    }

    public void setDox(StringFilter dox) {
        this.dox = dox;
    }

    public StringFilter getnDox() {
        return nDox;
    }

    public void setnDox(StringFilter nDox) {
        this.nDox = nDox;
    }

    public LongFilter getNetworkMasterId() {
        return networkMasterId;
    }

    public void setNetworkMasterId(LongFilter networkMasterId) {
        this.networkMasterId = networkMasterId;
    }

    public LongFilter getServiceMasterId() {
        return serviceMasterId;
    }

    public void setServiceMasterId(LongFilter serviceMasterId) {
        this.serviceMasterId = serviceMasterId;
    }

    public LongFilter getCityMasterId() {
        return cityMasterId;
    }

    public void setCityMasterId(LongFilter cityMasterId) {
        this.cityMasterId = cityMasterId;
    }

    public LongFilter getLocationWiseId() {
        return locationWiseId;
    }

    public void setLocationWiseId(LongFilter locationWiseId) {
        this.locationWiseId = locationWiseId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final StandardTariffCriteria that = (StandardTariffCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(fromWeight, that.fromWeight) &&
            Objects.equals(toWeight, that.toWeight) &&
            Objects.equals(dox, that.dox) &&
            Objects.equals(nDox, that.nDox) &&
            Objects.equals(networkMasterId, that.networkMasterId) &&
            Objects.equals(serviceMasterId, that.serviceMasterId) &&
            Objects.equals(cityMasterId, that.cityMasterId) &&
            Objects.equals(locationWiseId, that.locationWiseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        fromWeight,
        toWeight,
        dox,
        nDox,
        networkMasterId,
        serviceMasterId,
        cityMasterId,
        locationWiseId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StandardTariffCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (fromWeight != null ? "fromWeight=" + fromWeight + ", " : "") +
                (toWeight != null ? "toWeight=" + toWeight + ", " : "") +
                (dox != null ? "dox=" + dox + ", " : "") +
                (nDox != null ? "nDox=" + nDox + ", " : "") +
                (networkMasterId != null ? "networkMasterId=" + networkMasterId + ", " : "") +
                (serviceMasterId != null ? "serviceMasterId=" + serviceMasterId + ", " : "") +
                (cityMasterId != null ? "cityMasterId=" + cityMasterId + ", " : "") +
                (locationWiseId != null ? "locationWiseId=" + locationWiseId + ", " : "") +
            "}";
    }

}
