package tn.iit.gestabs.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.iit.gestabs.entites.Seance;

@Stateless
@LocalBean
public class SeanceServices implements SeanceServicesLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Seance> getAll() {
		return em.createQuery("SELECT u FROM Seance u", Seance.class).getResultList();
	}

	@Override
	public Seance getById(long id) {
		return em.find(Seance.class, id);
	}

	@Override
	public void add(Seance s) {
		em.persist(s);
	}

	@Override
	public void delete(long id) {
		Seance s = getById(id);
		em.remove(em.contains(s) ? s : em.merge(s));
	}

	@Override
	public void modifier(Seance s) {
		em.merge(s);
	}

	@Override
	public List<Seance> getByDate(String date) {
		return em.createQuery("SELECT u FROM Seance u WHERE u.dateSeance LIKE '%" + date + "%'", Seance.class)
				.getResultList();
	}

}
