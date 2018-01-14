package tn.iit.gestabs.services;

import java.util.List;
import javax.ejb.Local;

import tn.iit.gestabs.entites.Niveau;

@Local
public interface NiveauServicesLocal {
	List<Niveau> getAll();
	Niveau getById(long id);
	void add(Niveau s);
	void delete(long id);
	void modifier(Niveau s);
}
