package com.patclinic.patclinic.repository.jpa;

import com.patclinic.patclinic.repository.PetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import com.patclinic.patclinic.model.Pet;
import com.patclinic.patclinic.model.PetType;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaPetRepositoryImpl implements PetRepository
{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PetType> findPetTypes() throws DataAccessException {
        Query query = this.em.createQuery("SELECT ptype from PetType ptype order by ptype.name");

        return query.getResultList();
    }

    @Override
    public Pet findById(int id) throws DataAccessException {

        return this.em.find(Pet.class, id);

//        Query query = this.em.createQuery("SELECT pet from Pet pet where pet.id=:id");
//        query.setParameter("id",id);
//        return (Pet)query.getSingleResult();
//
      }

    @Override
    public Collection<Pet> findAll() throws DataAccessException {
        return this.em.createQuery("select pet from Pet pet").getResultList();
    }

    @Override
    public void saveOrUpdatePet(Pet pet) throws DataAccessException {

        Optional<Integer> petId = Optional.ofNullable(pet.getId());
        petId.ifPresentOrElse(
                id -> em.merge(pet),
                () -> em.persist(pet)
        );

    }

    @Override
    public void delete(Pet pet) throws DataAccessException {

//        this.em.remove(this.em.contains(pet)? pet : this.em.merge(pet));

        String petId = pet.getId().toString();

        this.em.createQuery("DELETE from  Visits visit  WHERE visit.pets.id="+petId).executeUpdate();
        this.em.createQuery("DELETE from Pet pet where pet.id="+petId).executeUpdate();

        if(em.contains(pet)){
            em.remove(pet);
        }



    }
}
