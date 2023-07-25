package com.patclinic.patclinic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name="visits")
public class Visits extends  BaseEnitity{
    @Column(name="visit_date", columnDefinition = "DATE")
    private LocalDate visitDate;
    @NotNull
    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pets;

    /**
     * Creates a new instance of Visit for the current date
     */
    public Visits() {
        this.visitDate = LocalDate.now();
    }


    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPets() {
        return pets;
    }

    public void setPets(Pet pets) {
        this.pets = pets;
    }
}
