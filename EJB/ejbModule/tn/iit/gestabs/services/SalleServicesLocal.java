package tn.iit.gestabs.services;

import java.util.List;
import javax.ejb.Local;

import tn.iit.gestabs.entites.Salle;

@Local
public interface SalleServicesLocal {
	List<Salle> getAll();
	Salle getById(long id);
	void add(Salle s);
	void delete(long id);
	void modifier(Salle s);
}
