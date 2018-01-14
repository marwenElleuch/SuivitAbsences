package tn.iit.gestabs.services;

import java.util.List;
import javax.ejb.Local;

import tn.iit.gestabs.entites.Matiere;

@Local
public interface MatiereServicesLocal {
	List<Matiere> getAll();
	Matiere getById(long id);
	void add(Matiere s);
	void delete(long id);
	void modifier(Matiere s);
}
