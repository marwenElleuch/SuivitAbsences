package tn.iit.gestabs.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.iit.gestabs.entites.Salle;

@Stateless
@LocalBean
public class SalleServices implements SalleServicesLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Salle> getAll() {
		return em.createQuery("SELECT u FROM Salle u", Salle.class).getResultList();
	}

	@Override
	public Salle getById(long id) {
		return em.find(Salle.class, id);
	}

	@Override
	public void add(Salle s) {
		em.persist(s);
	}

	@Override
	public void delete(long id) {
		Salle s = getById(id);
		em.remove(em.contains(s) ? s : em.merge(s));
	}

	@Override
	public void modifier(Salle s) {
		em.merge(s);
	}

}
