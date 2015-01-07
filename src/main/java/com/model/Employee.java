package com.model;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="EMPLOYEES_SQ", sequenceName="EMPLOYEES_SQ")
    @GeneratedValue(generator = "EMPLOYEES_SQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SUR_NAME")
    private String surName;

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

}
