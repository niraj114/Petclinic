package com.patclinic.patclinic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name="owners")
public class Owner extends  Person{


    @Column(name ="address")
    @NotEmpty
    private String address;

    @Column(name="city")
    @NotNull
    private String city;

    @Column(name="telephone")
    @NotNull
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> pets;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }





}
