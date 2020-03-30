package com.rrpserivce.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String userName;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "contact")
    private String contact;

    public User() {
    }

    @Column(name = "login_time")
    private Date login_time;
    @OneToOne
    private Role role;

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    @OneToOne
    private Company company;

    public void setPassword(String password) {
        this.password = password;
    }
}
