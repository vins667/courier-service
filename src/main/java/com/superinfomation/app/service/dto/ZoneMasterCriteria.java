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
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the {@link com.superinfomation.app.domain.ZoneMaster} entity. This class is used
 * in {@link com.superinfomation.app.web.rest.ZoneMasterResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /zone-masters?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ZoneMasterCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter zoneCode;

    private StringFilter zoneName;

    private StringFilter createdBy;

    private LocalDateFilter createdDate;

    private StringFilter lastUpdatedBy;

    private LocalDateFilter lastUpdatedDate;

    public ZoneMasterCriteria() {
    }

    public ZoneMasterCriteria(ZoneMasterCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.zoneCode = other.zoneCode == null ? null : other.zoneCode.copy();
        this.zoneName = other.zoneName == null ? null : other.zoneName.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdDate = other.createdDate == null ? null : other.createdDate.copy();
        this.lastUpdatedBy = other.lastUpdatedBy == null ? null : other.lastUpdatedBy.copy();
        this.lastUpdatedDate = other.lastUpdatedDate == null ? null : other.lastUpdatedDate.copy();
    }

    @Override
    public ZoneMasterCriteria copy() {
        return new ZoneMasterCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(StringFilter zoneCode) {
        this.zoneCode = zoneCode;
    }

    public StringFilter getZoneName() {
        return zoneName;
    }

    public void setZoneName(StringFilter zoneName) {
        this.zoneName = zoneName;
    }

    public StringFilter getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(StringFilter createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateFilter getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateFilter createdDate) {
        this.createdDate = createdDate;
    }

    public StringFilter getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(StringFilter lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public LocalDateFilter getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateFilter lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ZoneMasterCriteria that = (ZoneMasterCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(zoneCode, that.zoneCode) &&
            Objects.equals(zoneName, that.zoneName) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdDate, that.createdDate) &&
            Objects.equals(lastUpdatedBy, that.lastUpdatedBy) &&
            Objects.equals(lastUpdatedDate, that.lastUpdatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        zoneCode,
        zoneName,
        createdBy,
        createdDate,
        lastUpdatedBy,
        lastUpdatedDate
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ZoneMasterCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (zoneCode != null ? "zoneCode=" + zoneCode + ", " : "") +
                (zoneName != null ? "zoneName=" + zoneName + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdDate != null ? "createdDate=" + createdDate + ", " : "") +
                (lastUpdatedBy != null ? "lastUpdatedBy=" + lastUpdatedBy + ", " : "") +
                (lastUpdatedDate != null ? "lastUpdatedDate=" + lastUpdatedDate + ", " : "") +
            "}";
    }

}
