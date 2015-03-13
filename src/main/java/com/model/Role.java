package com.model;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="ROLE_SQ", sequenceName="ROLE_SQ")
    @GeneratedValue(generator = "ROLE_SQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "SYS_NAME")
    private String sysName;

    @Column(name = "DESCRIPTION")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
