package com.superinfomation.app.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.superinfomation.app.domain.ServiceMaster} entity.
 */
public class ServiceMasterDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 10)
    private String serviceCode;

    @NotNull
    @Size(min = 2, max = 20)
    private String serviceName;

    @NotNull
    private Double dimensioncharge;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getDimensioncharge() {
        return dimensioncharge;
    }

    public void setDimensioncharge(Double dimensioncharge) {
        this.dimensioncharge = dimensioncharge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ServiceMasterDTO)) {
            return false;
        }

        return id != null && id.equals(((ServiceMasterDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ServiceMasterDTO{" +
            "id=" + getId() +
            ", serviceCode='" + getServiceCode() + "'" +
            ", serviceName='" + getServiceName() + "'" +
            ", dimensioncharge=" + getDimensioncharge() +
            "}";
    }
}
