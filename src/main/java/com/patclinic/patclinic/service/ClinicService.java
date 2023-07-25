package com.patclinic.patclinic.service;

import com.patclinic.patclinic.model.Owner;
import com.patclinic.patclinic.model.Pet;
import com.patclinic.patclinic.model.PetType;
import com.patclinic.patclinic.model.Visits;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface ClinicService {

    Pet findPetById(int id) throws DataAccessException;
    Collection<Pet> findAllPets() throws DataAccessException;
    void savePet(Pet pet) throws DataAccessException;
    void deletePet(Pet pet) throws DataAccessException;

    Collection<Visits> findVisitsByPetId(int petId);
    Visits findVisitById(int visitId) throws DataAccessException;
    Collection<Visits> findAllVisits() throws DataAccessException;
    void saveVisit(Visits visit) throws DataAccessException;
    void deleteVisit(Visits visit) throws DataAccessException;

    Owner findOwnerById(int id) throws DataAccessException;
    Collection<Owner> findAllOwners() throws DataAccessException;
    void saveOwner(Owner owner) throws DataAccessException;
    void deleteOwner(Owner owner) throws DataAccessException;
    Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException;

    PetType findPetTypeById(int petTypeId);
    Collection<PetType> findAllPetTypes() throws DataAccessException;
    Collection<PetType> findPetTypes() throws DataAccessException;
    void savePetType(PetType petType) throws DataAccessException;
    void deletePetType(PetType petType) throws DataAccessException;
}
