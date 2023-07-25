package com.patclinic.patclinic.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="pets")
public class Pet extends NamedEntity{

    @Column(name ="birth_date", columnDefinition = "DATE")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;
    @OneToMany(cascade =CascadeType.ALL ,mappedBy = "pets", fetch = FetchType.EAGER)
    private Set<Visits> visit;

    public Set<Visits> getVisit() {
        return visit;
    }

    public void setVisit(Set<Visits> visit) {
        this.visit = visit;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
