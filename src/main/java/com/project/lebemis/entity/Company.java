package com.project.lebemis.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Company {
    private Integer id;
    private String name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "companyByCompanyId")
    public Collection<Device> getDevicesById() {
        return devicesById;
    }

    public void setDevicesById(Collection<Device> devicesById) {
        this.devicesById = devicesById;
    }
}
