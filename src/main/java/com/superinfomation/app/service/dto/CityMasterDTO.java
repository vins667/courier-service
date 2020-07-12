package com.superinfomation.app.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.superinfomation.app.domain.CityMaster} entity.
 */
public class CityMasterDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 20)
    private String code;

    @NotNull
    @Size(min = 2, max = 20)
    private String cityName;

    @NotNull
    @Size(min = 6, max = 9)
    private String pinCode;


    private Long stateMasterId;

    private String stateMasterStateName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Long getStateMasterId() {
        return stateMasterId;
    }

    public void setStateMasterId(Long stateMasterId) {
        this.stateMasterId = stateMasterId;
    }

    public String getStateMasterStateName() {
        return stateMasterStateName;
    }

    public void setStateMasterStateName(String stateMasterStateName) {
        this.stateMasterStateName = stateMasterStateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CityMasterDTO)) {
            return false;
        }

        return id != null && id.equals(((CityMasterDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CityMasterDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", cityName='" + getCityName() + "'" +
            ", pinCode='" + getPinCode() + "'" +
            ", stateMasterId=" + getStateMasterId() +
            ", stateMasterStateName='" + getStateMasterStateName() + "'" +
            "}";
    }
}
