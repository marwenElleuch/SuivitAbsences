package tn.iit.gestabs.services;

import java.util.List;
import javax.ejb.Local;

import tn.iit.gestabs.entites.Enseignant;

@Local
public interface EnseignantServicesLocal {
	List<Enseignant> getAll();
	Enseignant getById(long id);
	void add(Enseignant s);
	void delete(long id);
	void modifier(Enseignant s);
}
