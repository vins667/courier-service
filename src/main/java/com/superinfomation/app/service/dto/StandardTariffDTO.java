package com.superinfomation.app.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.superinfomation.app.domain.StandardTariff} entity.
 */
public class StandardTariffDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Double fromWeight;

    @NotNull
    private Double toWeight;

    @NotNull
    private String dox;

    @NotNull
    private String nDox;


    private Long networkMasterId;

    private String networkMasterNetworkName;

    private Long serviceMasterId;

    private String serviceMasterServiceName;

    private Long cityMasterId;

    private String cityMasterCityName;

    private Long locationWiseId;

    private String locationWiseCityName;
    
    private String locationWise;
    private String location;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFromWeight() {
        return fromWeight;
    }

    public void setFromWeight(Double fromWeight) {
        this.fromWeight = fromWeight;
    }

    public Double getToWeight() {
        return toWeight;
    }

    public void setToWeight(Double toWeight) {
        this.toWeight = toWeight;
    }

    public String getDox() {
        return dox;
    }

    public void setDox(String dox) {
        this.dox = dox;
    }

    public String getnDox() {
        return nDox;
    }

    public void setnDox(String nDox) {
        this.nDox = nDox;
    }

    public Long getNetworkMasterId() {
        return networkMasterId;
    }

    public void setNetworkMasterId(Long networkMasterId) {
        this.networkMasterId = networkMasterId;
    }

    public String getNetworkMasterNetworkName() {
        return networkMasterNetworkName;
    }

    public void setNetworkMasterNetworkName(String networkMasterNetworkName) {
        this.networkMasterNetworkName = networkMasterNetworkName;
    }

    public Long getServiceMasterId() {
        return serviceMasterId;
    }

    public void setServiceMasterId(Long serviceMasterId) {
        this.serviceMasterId = serviceMasterId;
    }

    public String getServiceMasterServiceName() {
        return serviceMasterServiceName;
    }

    public void setServiceMasterServiceName(String serviceMasterServiceName) {
        this.serviceMasterServiceName = serviceMasterServiceName;
    }

    public Long getCityMasterId() {
        return cityMasterId;
    }

    public void setCityMasterId(Long cityMasterId) {
        this.cityMasterId = cityMasterId;
    }

    public String getCityMasterCityName() {
        return cityMasterCityName;
    }

    public void setCityMasterCityName(String cityMasterCityName) {
        this.cityMasterCityName = cityMasterCityName;
    }

    public Long getLocationWiseId() {
        return locationWiseId;
    }

    public void setLocationWiseId(Long cityMasterId) {
        this.locationWiseId = cityMasterId;
    }

    public String getLocationWiseCityName() {
        return locationWiseCityName;
    }

    public void setLocationWiseCityName(String cityMasterCityName) {
        this.locationWiseCityName = cityMasterCityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StandardTariffDTO)) {
            return false;
        }

        return id != null && id.equals(((StandardTariffDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public String getLocationWise() {
		return locationWise;
	}

	public void setLocationWise(String locationWise) {
		this.locationWise = locationWise;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "StandardTariffDTO [id=" + id + ", fromWeight=" + fromWeight + ", toWeight=" + toWeight + ", dox=" + dox
				+ ", nDox=" + nDox + ", networkMasterId=" + networkMasterId + ", networkMasterNetworkName="
				+ networkMasterNetworkName + ", serviceMasterId=" + serviceMasterId + ", serviceMasterServiceName="
				+ serviceMasterServiceName + ", cityMasterId=" + cityMasterId + ", cityMasterCityName="
				+ cityMasterCityName + ", locationWiseId=" + locationWiseId + ", locationWiseCityName="
				+ locationWiseCityName + ", locationWise=" + locationWise + ", location=" + location + "]";
	}
}
