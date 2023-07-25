package com.patclinic.patclinic.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.patclinic.patclinic.model.Visits;
import org.springframework.dao.DataAccessException;
import com.patclinic.patclinic.repository.VisitRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public class JpaVisitRepository implements VisitRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Visits> findByPetId(int petId) throws DataAccessException {
        return this.em.createQuery("select visit from Visits visit where visit.pets.id=:petId")
                .setParameter("petId",petId).getResultList();
    }

    @Override
    public Visits findById(int id) throws DataAccessException {
        return em.find(Visits.class, id);
    }

    @Override
    public Collection<Visits> findAll() throws DataAccessException {
        return this.em.createQuery("select visit from Visits visit")
             .getResultList();

    }

    @Override
    public void saveOrUpdateVisit(Visits visits) throws DataAccessException {

        Optional<Integer> visitId = Optional.ofNullable(visits.getId());

        visitId.ifPresentOrElse(
                id -> em.merge(visits),
                () -> em.persist(visits)
        );

    }

    @Override
    public void delete(Visits visits) throws DataAccessException {
        this.em.remove(this.em.contains(visits)? visits : this.em.merge(visits));

    }
}
