package com.project.lebemis.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_device", schema = "public", catalog = "lebemisdb")
public class UsersDevice {
    private Integer id;
    private Integer userId;
    private Integer deviceId;
    private Integer usingHoursPerMonth;
    private User userByUserId;
    private Device deviceByDeviceId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "device_id", nullable = false)
    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "using_hours_per_month", nullable = true)
    public Integer getUsingHoursPerMonth() {
        return usingHoursPerMonth;
    }

    public void setUsingHoursPerMonth(Integer usingHoursPerMonth) {
        this.usingHoursPerMonth = usingHoursPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersDevice that = (UsersDevice) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(usingHoursPerMonth, that.usingHoursPerMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, deviceId, usingHoursPerMonth);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id", nullable = false)
    public Device getDeviceByDeviceId() {
        return deviceByDeviceId;
    }

    public void setDeviceByDeviceId(Device deviceByDeviceId) {
        this.deviceByDeviceId = deviceByDeviceId;
    }
}
