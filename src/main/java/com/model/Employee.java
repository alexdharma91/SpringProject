package com.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="EMPLOYEES_SQ", sequenceName="EMPLOYEES_SQ")
    @GeneratedValue(generator = "EMPLOYEES_SQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SUR_NAME")
    private String surName;

    @Column(name = "LOGIN", unique = true)
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
