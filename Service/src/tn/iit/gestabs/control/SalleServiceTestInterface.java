package tn.iit.gestabs.control;

import java.util.List;

import tn.iit.gestabs.entites.Salle;


public interface SalleServiceTestInterface {
	public List<Salle> getAll();

	public void add(Salle salle);

	public Salle getById(Long id);

	public void edit(long id, Salle salle);

	public void delete(long id);


}
