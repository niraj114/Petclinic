package com.patclinic.patclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="types")
public class PetType extends  NamedEntity{
}
