package com.superinfomation.app.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.superinfomation.app.domain.StateMaster} entity.
 */
public class StateMasterDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 5)
    private String code;

    @NotNull
    @Size(min = 2, max = 20)
    private String stateName;


    private Long countryMasterId;
    
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

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Long getCountryMasterId() {
        return countryMasterId;
    }

    public void setCountryMasterId(Long countryMasterId) {
        this.countryMasterId = countryMasterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StateMasterDTO)) {
            return false;
        }

        return id != null && id.equals(((StateMasterDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StateMasterDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", stateName='" + getStateName() + "'" +
            ", countryMasterId=" + getCountryMasterId() +
            "}";
    }
}
