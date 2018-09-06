package com.project.lebemis.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Device {
    private Integer id;
    private String model;
    private Integer typeId;
    private Integer companyId;
    private Double wattPlay;
    private Integer since;
    private String country;
    private Double wattWait;
    private Type typeByTypeId;
    private Company companyByCompanyId;
    private Collection<UsersDevice> usersDevicesById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "model", nullable = true, length = 255)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "type_id", nullable = false)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "company_id", nullable = false)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "watt_play", nullable = true, precision = 0)
    public Double getWattPlay() {
        return wattPlay;
    }

    public void setWattPlay(Double wattPlay) {
        this.wattPlay = wattPlay;
    }

    @Basic
    @Column(name = "since", nullable = true)
    public Integer getSince() {
        return since;
    }

    public void setSince(Integer since) {
        this.since = since;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "watt_wait", nullable = true, precision = 0)
    public Double getWattWait() {
        return wattWait;
    }

    public void setWattWait(Double wattWait) {
        this.wattWait = wattWait;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(id, device.id) &&
                Objects.equals(model, device.model) &&
                Objects.equals(typeId, device.typeId) &&
                Objects.equals(companyId, device.companyId) &&
                Objects.equals(wattPlay, device.wattPlay) &&
                Objects.equals(since, device.since) &&
                Objects.equals(country, device.country) &&
                Objects.equals(wattWait, device.wattWait);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, typeId, companyId, wattPlay, since, country, wattWait);
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    public Company getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(Company companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }

    @OneToMany(mappedBy = "deviceByDeviceId")
    public Collection<UsersDevice> getUsersDevicesById() {
        return usersDevicesById;
    }

    public void setUsersDevicesById(Collection<UsersDevice> usersDevicesById) {
        this.usersDevicesById = usersDevicesById;
    }
}
