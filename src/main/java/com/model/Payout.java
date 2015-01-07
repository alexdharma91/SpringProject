package com.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PAYOUTS")
public class Payout {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="PAYOUTS_SQ", sequenceName="PAYOUTS_SQ")
    @GeneratedValue(generator = "PAYOUTS_SQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "INITIATOR_ID")
    private Long initiatorId;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "TYPE")
    private String type;

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

    public Long getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(Long initiatorId) {
        this.initiatorId = initiatorId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
