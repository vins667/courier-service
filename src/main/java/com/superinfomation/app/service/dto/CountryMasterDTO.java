package com.superinfomation.app.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.superinfomation.app.domain.CountryMaster} entity.
 */
public class CountryMasterDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 3)
    private String code;

    @NotNull
    @Size(min = 2, max = 20)
    private String countryName;

    
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CountryMasterDTO)) {
            return false;
        }

        return id != null && id.equals(((CountryMasterDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CountryMasterDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", countryName='" + getCountryName() + "'" +
            "}";
    }
}
