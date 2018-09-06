package com.project.lebemis.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "typez")
public class Type {
    private Integer id;
    private String name;
    private Double avgWatt;
    private Integer avgHoursPerMonth;
    private Collection<Device> devicesById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "avg_watt", nullable = true, precision = 0)
    public Double getAvgWatt() {
        return avgWatt;
    }

    public void setAvgWatt(Double avgWatt) {
        this.avgWatt = avgWatt;
    }

    @Basic
    @Column(name = "avg_hours_per_month", nullable = true)
    public Integer getAvgHoursPerMonth() {
        return avgHoursPerMonth;
    }

    public void setAvgHoursPerMonth(Integer avgHoursPerMonth) {
        this.avgHoursPerMonth = avgHoursPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(id, type.id) &&
                Objects.equals(name, type.name) &&
                Objects.equals(avgWatt, type.avgWatt) &&
                Objects.equals(avgHoursPerMonth, type.avgHoursPerMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, avgWatt, avgHoursPerMonth);
    }

    @OneToMany(mappedBy = "typezByTypeId")
    public Collection<Device> getDevicesById() {
        return devicesById;
    }

    public void setDevicesById(Collection<Device> devicesById) {
        this.devicesById = devicesById;
    }
}
