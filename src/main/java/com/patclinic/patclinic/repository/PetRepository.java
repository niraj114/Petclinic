package com.patclinic.patclinic.repository;

import com.patclinic.patclinic.model.Pet;
import com.patclinic.patclinic.model.PetType;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


public interface PetRepository {

    List<PetType> findPetTypes() throws DataAccessException;

    Pet findById(int id) throws DataAccessException;

    Collection<Pet> findAll() throws DataAccessException;

    void saveOrUpdatePet(Pet pet) throws  DataAccessException;

    void delete(Pet pet) throws  DataAccessException;


}
