package tn.iit.gestabs.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.iit.gestabs.entites.Matiere;

@Stateless
@LocalBean
public class MatiereServices implements MatiereServicesLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Matiere> getAll() {
		return em.createQuery("SELECT u FROM Matiere u", Matiere.class).getResultList();
	}

	@Override
	public Matiere getById(long id) {
		return em.find(Matiere.class, id);
	}

	@Override
	public void add(Matiere s) {
		em.persist(s);
	}

	@Override
	public void delete(long id) {
		Matiere s = getById(id);
		em.remove(em.contains(s) ? s : em.merge(s));
	}

	@Override
	public void modifier(Matiere s) {
		em.merge(s);
	}

}
