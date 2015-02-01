package com.model;

import javax.persistence.*;

@Entity
@Table(name = "ABSENCE_TYPES")
public class AbsenceType {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="ABSENCES_SQ", sequenceName="ABSENCES_SQ")
    @GeneratedValue(generator = "ABSENCES_SQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
