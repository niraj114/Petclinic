package com.patclinic.patclinic.repository;

import com.patclinic.patclinic.model.Visits;
import org.springframework.dao.DataAccessException;

import java.util.Collection;
import java.util.List;

public interface VisitRepository {

    List<Visits> findByPetId(int petId) throws DataAccessException;

    Visits findById(int id) throws DataAccessException;

    Collection<Visits> findAll() throws DataAccessException;

    void saveOrUpdateVisit(Visits visits) throws  DataAccessException;

    void delete(Visits visits) throws  DataAccessException;




}
