package tn.iit.gestabs.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.iit.gestabs.entites.Enseignant;

@Stateless
@LocalBean
public class EnseignantServices implements EnseignantServicesLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Enseignant> getAll() {
		return em.createQuery("SELECT u FROM Enseignant u", Enseignant.class).getResultList();
	}

	@Override
	public Enseignant getById(long id) {
		return em.find(Enseignant.class, id);
	}

	@Override
	public void add(Enseignant s) {
		em.persist(s);
	}

	@Override
	public void delete(long id) {
		Enseignant s = getById(id);
		em.remove(em.contains(s) ? s : em.merge(s));
	}

	@Override
	public void modifier(Enseignant s) {
		em.merge(s);
	}

}
