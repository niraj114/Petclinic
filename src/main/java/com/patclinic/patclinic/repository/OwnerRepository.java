package com.patclinic.patclinic.repository;

import com.patclinic.patclinic.model.Owner;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface OwnerRepository {


   Collection<Owner> findByLastName(String name) throws DataAccessException;

   Owner findById(int id) throws DataAccessException;

   void saveOrUpdateOwner(Owner owner) throws DataAccessException;


   Collection<Owner> findAll() throws DataAccessException;


   void delete(Owner owner) throws DataAccessException;





}
