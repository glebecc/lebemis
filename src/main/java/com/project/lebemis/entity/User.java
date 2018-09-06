package com.project.lebemis.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usr")
public class User {
    private Long id;
    private String password;
    private String username;
    private Collection<Message> messagesById;
    private Collection<UsersDevice> usersDevicesById;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(password, user.password) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, username);
    }

    @OneToMany(mappedBy = "usrByUserId")
    public Collection<Message> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<Message> messagesById) {
        this.messagesById = messagesById;
    }

    @OneToMany(mappedBy = "usrByUserId")
    public Collection<UsersDevice> getUsersDevicesById() {
        return usersDevicesById;
    }

    public void setUsersDevicesById(Collection<UsersDevice> usersDevicesById) {
        this.usersDevicesById = usersDevicesById;
    }
}
