package com.superinfomation.app.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * A ServiceMaster.
 */
@Entity
@Table(name = "service_master")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "servicemaster")
public class ServiceMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="serviceMasterSeq", sequenceName="service_master_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="serviceMasterSeq")
    private Long id;

    @NotNull
    @Size(min = 2, max = 10)
    @Column(name = "service_code", length = 10, nullable = false)
    private String serviceCode;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "service_name", length = 20, nullable = false)
    private String serviceName;

    @NotNull
    @Column(name = "dimensioncharge", nullable = false)
    private Double dimensioncharge;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public ServiceMaster serviceCode(String serviceCode) {
        this.serviceCode = serviceCode;
        return this;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public ServiceMaster serviceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getDimensioncharge() {
        return dimensioncharge;
    }

    public ServiceMaster dimensioncharge(Double dimensioncharge) {
        this.dimensioncharge = dimensioncharge;
        return this;
    }

    public void setDimensioncharge(Double dimensioncharge) {
        this.dimensioncharge = dimensioncharge;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ServiceMaster)) {
            return false;
        }
        return id != null && id.equals(((ServiceMaster) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ServiceMaster{" +
            "id=" + getId() +
            ", serviceCode='" + getServiceCode() + "'" +
            ", serviceName='" + getServiceName() + "'" +
            ", dimensioncharge=" + getDimensioncharge() +
            "}";
    }
}
