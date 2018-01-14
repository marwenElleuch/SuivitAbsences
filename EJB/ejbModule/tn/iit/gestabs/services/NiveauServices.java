package tn.iit.gestabs.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.iit.gestabs.entites.Niveau;

@Stateless
@LocalBean
public class NiveauServices implements NiveauServicesLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Niveau> getAll() {
		return em.createQuery("SELECT u FROM Niveau u", Niveau.class).getResultList();
	}

	@Override
	public Niveau getById(long id) {
		return em.find(Niveau.class, id);
	}

	@Override
	public void add(Niveau s) {
		em.persist(s);
	}

	@Override
	public void delete(long id) {
		Niveau s = getById(id);
		em.remove(em.contains(s) ? s : em.merge(s));
	}

	@Override
	public void modifier(Niveau s) {
		em.merge(s);
	}

}
