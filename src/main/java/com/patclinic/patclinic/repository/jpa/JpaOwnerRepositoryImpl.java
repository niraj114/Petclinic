package com.patclinic.patclinic.repository.jpa;

import com.patclinic.patclinic.repository.OwnerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import com.patclinic.patclinic.model.Owner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class JpaOwnerRepositoryImpl implements OwnerRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Owner> findByLastName(String lastName) throws DataAccessException {
        // using 'join fetch' because a single query should load both owners and pets(N+1 issue)
        // using 'left join fetch' because it might happen that an owner does not have pets yet

        Query query = this.em.createQuery("select distinct owner from Owner owner left join fetch owner.pets where owner.lastName LIKE : lastName");
        query.setParameter("lastName",lastName+"%");
        return query.getResultList();
    }

    @Override
    public Owner findById(int id) throws DataAccessException {
        // using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("select owner FROM Owner owner left join fetch owner.pets WHERE owner.id=:id");
        query.setParameter("id",id);
        return (Owner) query.getSingleResult();
    }

    @Override
    public void saveOrUpdateOwner(Owner owner) throws DataAccessException {

        //java7

//        if(owner.getId()==null){
//           this.em.persist(owner);
//        }else {
//          this.em.merge(owner);
//        }

        //java8

        Optional<Integer> ownerId = Optional.ofNullable(owner.getId());

        ownerId.ifPresentOrElse(
                id -> em.persist(owner), // update if id is persent
                () -> em.merge(owner) // Insert if ID is not persent
        );


    }

    @Override
    public Collection<Owner> findAll() throws DataAccessException {

        Query query = this.em.createQuery("SELECT owner from Owner owner ");
        return query.getResultList();

    }

    @Override
    public void delete(Owner owner) throws DataAccessException {

        this.em.remove(this.em.contains(owner)? owner : this.em.merge(owner));

    }
}
