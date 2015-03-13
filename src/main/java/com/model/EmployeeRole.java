package com.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_ROLE")
public class EmployeeRole {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="EMPLOYEE_ROLE_SQ", sequenceName="EMPLOYEE_ROLE_SQ")
    @GeneratedValue(generator = "EMPLOYEE_ROLE_SQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "ROLE_ID")
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
