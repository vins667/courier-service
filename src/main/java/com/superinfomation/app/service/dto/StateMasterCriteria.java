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
 * Criteria class for the {@link com.superinfomation.app.domain.StateMaster} entity. This class is used
 * in {@link com.superinfomation.app.web.rest.StateMasterResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /state-masters?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class StateMasterCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter code;

    private StringFilter stateName;

    private LongFilter countryMasterId;

    public StateMasterCriteria() {
    }

    public StateMasterCriteria(StateMasterCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.code = other.code == null ? null : other.code.copy();
        this.stateName = other.stateName == null ? null : other.stateName.copy();
        this.countryMasterId = other.countryMasterId == null ? null : other.countryMasterId.copy();
    }

    @Override
    public StateMasterCriteria copy() {
        return new StateMasterCriteria(this);
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

    public StringFilter getStateName() {
        return stateName;
    }

    public void setStateName(StringFilter stateName) {
        this.stateName = stateName;
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
        final StateMasterCriteria that = (StateMasterCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(code, that.code) &&
            Objects.equals(stateName, that.stateName) &&
            Objects.equals(countryMasterId, that.countryMasterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        code,
        stateName,
        countryMasterId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StateMasterCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (code != null ? "code=" + code + ", " : "") +
                (stateName != null ? "stateName=" + stateName + ", " : "") +
                (countryMasterId != null ? "countryMasterId=" + countryMasterId + ", " : "") +
            "}";
    }

}
