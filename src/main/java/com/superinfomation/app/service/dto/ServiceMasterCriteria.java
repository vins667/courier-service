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
 * Criteria class for the {@link com.superinfomation.app.domain.ServiceMaster} entity. This class is used
 * in {@link com.superinfomation.app.web.rest.ServiceMasterResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /service-masters?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ServiceMasterCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter serviceCode;

    private StringFilter serviceName;

    private DoubleFilter dimensioncharge;

    public ServiceMasterCriteria() {
    }

    public ServiceMasterCriteria(ServiceMasterCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.serviceCode = other.serviceCode == null ? null : other.serviceCode.copy();
        this.serviceName = other.serviceName == null ? null : other.serviceName.copy();
        this.dimensioncharge = other.dimensioncharge == null ? null : other.dimensioncharge.copy();
    }

    @Override
    public ServiceMasterCriteria copy() {
        return new ServiceMasterCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(StringFilter serviceCode) {
        this.serviceCode = serviceCode;
    }

    public StringFilter getServiceName() {
        return serviceName;
    }

    public void setServiceName(StringFilter serviceName) {
        this.serviceName = serviceName;
    }

    public DoubleFilter getDimensioncharge() {
        return dimensioncharge;
    }

    public void setDimensioncharge(DoubleFilter dimensioncharge) {
        this.dimensioncharge = dimensioncharge;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ServiceMasterCriteria that = (ServiceMasterCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(serviceCode, that.serviceCode) &&
            Objects.equals(serviceName, that.serviceName) &&
            Objects.equals(dimensioncharge, that.dimensioncharge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        serviceCode,
        serviceName,
        dimensioncharge
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ServiceMasterCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (serviceCode != null ? "serviceCode=" + serviceCode + ", " : "") +
                (serviceName != null ? "serviceName=" + serviceName + ", " : "") +
                (dimensioncharge != null ? "dimensioncharge=" + dimensioncharge + ", " : "") +
            "}";
    }

}
