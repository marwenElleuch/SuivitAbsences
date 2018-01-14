package tn.iit.gestabs.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.iit.gestabs.entites.Departement;

@Stateless
@LocalBean
public class DepartementServices implements DepartementServicesLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Departement> getAll() {
		return em.createQuery("SELECT u FROM Departement u", Departement.class).getResultList();
	}

	@Override
	public Departement getById(long id) {
		return em.find(Departement.class, id);
	}

	@Override
	public void add(Departement s) {
		em.persist(s);
	}

	@Override
	public void delete(long id) {
		Departement s = getById(id);
		em.remove(em.contains(s) ? s : em.merge(s));
	}

	@Override
	public void modifier(Departement s) {
		em.merge(s);
	}

}
