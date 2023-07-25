package com.patclinic.patclinic.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.patclinic.patclinic.model.Pet;
import com.patclinic.patclinic.model.PetType;
import com.patclinic.patclinic.model.Visits;
import org.springframework.dao.DataAccessException;
import com.patclinic.patclinic.repository.PetTypeRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Repository
public class JpaPetTypeRepository implements PetTypeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public PetType findById(int id) throws DataAccessException {
        return this.em.find(PetType.class, id);
    }

    @Override
    public Collection<PetTypeRepository> findAll() throws DataAccessException {
        return em.createQuery("SELECt ptype from PetType ptype").getResultList();
    }

    @Override
    public void saveOrUpdatePetType(PetType petType) throws DataAccessException {

        Optional<Integer> petTypeId =Optional.ofNullable(petType.getId());
        petTypeId.ifPresentOrElse(
                id -> em.merge(petType),
                () -> em.persist(petType)
        );

    }

    @Override
    public void delete(PetType petType) throws DataAccessException {

//        this.em.remove(this.em.contains(petType)? petType : this.em.merge(petType));

         Integer petTypeId=  petType.getId();

        List<Pet> pet = this.em.createQuery("Select pet from Pet pet where pet.type" + petTypeId).getResultList();

        for(Pet p : pet){
            Set<Visits> visit  = p.getVisit();
            for(Visits v : visit){
              this.em.createQuery("delete from Visits visits where id="+v.getId()).executeUpdate();

            }
            this.em.createQuery("delete from Pet pet where id="+p.getId()).executeUpdate();
        }

        this.em.createQuery("delete  from PetType ptype where ptype.id="+petTypeId).executeUpdate();



    }
}
