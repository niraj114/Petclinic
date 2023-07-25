package com.patclinic.patclinic.service;

import com.patclinic.patclinic.model.Owner;
import com.patclinic.patclinic.model.Pet;
import com.patclinic.patclinic.model.PetType;
import com.patclinic.patclinic.model.Visits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.patclinic.patclinic.repository.OwnerRepository;
import com.patclinic.patclinic.repository.PetRepository;
import com.patclinic.patclinic.repository.PetTypeRepository;
import com.patclinic.patclinic.repository.VisitRepository;

import java.util.Collection;
@Service
public class ClinicServiceImpl implements ClinicService{


    private OwnerRepository ownerRepository;

    private PetRepository petRepository;

    private VisitRepository visitRepository;

    private PetTypeRepository petTypeRepository;
    @Autowired
    public ClinicServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository, VisitRepository visitRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.visitRepository = visitRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Pet findPetById(int id) throws DataAccessException {
        Pet pet = petRepository.findById(id);

        return pet;
    }

    @Override
    @Transactional(readOnly  = true)
    public Collection<Pet> findAllPets() throws DataAccessException {
        Collection<Pet> pets = petRepository.findAll();
        return pets;
    }

    @Override
    @Transactional
    public void savePet(Pet pet) throws DataAccessException {
        petRepository.saveOrUpdatePet(pet);

    }

    @Override
    public void deletePet(Pet pet) throws DataAccessException {
        petRepository.delete(pet);
    }

    @Override
    public Collection<Visits> findVisitsByPetId(int petId) {
        return null;
    }

    @Override
    public Visits findVisitById(int visitId) throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Visits> findAllVisits() throws DataAccessException {
        return null;
    }

    @Override
    public void saveVisit(Visits visit) throws DataAccessException {

    }

    @Override
    public void deleteVisit(Visits visit) throws DataAccessException {

    }

    @Override
    public Owner findOwnerById(int id) throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Owner> findAllOwners() throws DataAccessException {
        return null;
    }

    @Override
    public void saveOwner(Owner owner) throws DataAccessException {

    }

    @Override
    public void deleteOwner(Owner owner) throws DataAccessException {

    }

    @Override
    public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
        return null;
    }

    @Override
    public PetType findPetTypeById(int petTypeId) {
        return null;
    }

    @Override
    public Collection<PetType> findAllPetTypes() throws DataAccessException {
        return null;
    }

    @Override
    public Collection<PetType> findPetTypes() throws DataAccessException {
        return null;
    }

    @Override
    public void savePetType(PetType petType) throws DataAccessException {

    }

    @Override
    public void deletePetType(PetType petType) throws DataAccessException {

    }
}
