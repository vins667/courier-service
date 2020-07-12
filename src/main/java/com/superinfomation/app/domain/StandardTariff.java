package com.superinfomation.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * A StandardTariff.
 */
@Entity
@Table(name = "standard_tariff")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "standardtariff")
public class StandardTariff implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="serviceMasterSeq", sequenceName="service_master_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="serviceMasterSeq")
    private Long id;

    @NotNull
    @Column(name = "from_weight", nullable = false)
    private Double fromWeight;

    @NotNull
    @Column(name = "to_weight", nullable = false)
    private Double toWeight;

    @NotNull
    @Column(name = "dox", nullable = false)
    private String dox;

    @NotNull
    @Column(name = "n_dox", nullable = false)
    private String nDox;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "standardTariffs", allowSetters = true)
    @JoinColumn(name="network_master_id")
    private NetworkMaster networkMaster;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "standardTariffs", allowSetters = true)
    @JoinColumn(name="service_master_id")
    private ServiceMaster serviceMaster;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "standardTariffs", allowSetters = true)
    @JoinColumn(name="city_master_id")
    private CityMaster cityMaster;

    @Column(name="location_wise")
    private String locationWise;

    @Column(name="location_id")
    private Long location;
    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFromWeight() {
        return fromWeight;
    }

    public StandardTariff fromWeight(Double fromWeight) {
        this.fromWeight = fromWeight;
        return this;
    }

    public void setFromWeight(Double fromWeight) {
        this.fromWeight = fromWeight;
    }

    public Double getToWeight() {
        return toWeight;
    }

    public StandardTariff toWeight(Double toWeight) {
        this.toWeight = toWeight;
        return this;
    }

    public void setToWeight(Double toWeight) {
        this.toWeight = toWeight;
    }

    public String getDox() {
        return dox;
    }

    public StandardTariff dox(String dox) {
        this.dox = dox;
        return this;
    }

    public void setDox(String dox) {
        this.dox = dox;
    }

    public String getnDox() {
        return nDox;
    }

    public StandardTariff nDox(String nDox) {
        this.nDox = nDox;
        return this;
    }

    public void setnDox(String nDox) {
        this.nDox = nDox;
    }

    public NetworkMaster getNetworkMaster() {
        return networkMaster;
    }

    public StandardTariff networkMaster(NetworkMaster networkMaster) {
        this.networkMaster = networkMaster;
        return this;
    }

    public void setNetworkMaster(NetworkMaster networkMaster) {
        this.networkMaster = networkMaster;
    }

    public ServiceMaster getServiceMaster() {
        return serviceMaster;
    }

    public StandardTariff serviceMaster(ServiceMaster serviceMaster) {
        this.serviceMaster = serviceMaster;
        return this;
    }

    public void setServiceMaster(ServiceMaster serviceMaster) {
        this.serviceMaster = serviceMaster;
    }

    public CityMaster getCityMaster() {
        return cityMaster;
    }

    public StandardTariff cityMaster(CityMaster cityMaster) {
        this.cityMaster = cityMaster;
        return this;
    }

    public void setCityMaster(CityMaster cityMaster) {
        this.cityMaster = cityMaster;
    }

    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StandardTariff)) {
            return false;
        }
        return id != null && id.equals(((StandardTariff) o).id);
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

	public Long getLocation() {
		return location;
	}

	public void setLocation(Long location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "StandardTariff [id=" + id + ", fromWeight=" + fromWeight + ", toWeight=" + toWeight + ", dox=" + dox
				+ ", nDox=" + nDox + ", networkMaster=" + networkMaster + ", serviceMaster=" + serviceMaster
				+ ", cityMaster=" + cityMaster + ", locationWise=" + locationWise + ", location=" + location + "]";
	}
}
