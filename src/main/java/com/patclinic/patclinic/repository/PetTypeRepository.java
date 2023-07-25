package com.patclinic.patclinic.repository;

import com.patclinic.patclinic.model.PetType;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface PetTypeRepository {

    PetType findById(int id) throws DataAccessException;

    Collection<PetTypeRepository> findAll() throws  DataAccessException;

    void saveOrUpdatePetType(PetType petType) throws DataAccessException;

    void delete(PetType petType) throws DataAccessException;








}
