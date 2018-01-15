package tn.iit.gestabs.services;

import java.util.List;
import javax.ejb.Local;

import tn.iit.gestabs.entites.Departement;

@Local
public interface DepartementServicesLocal {
	List<Departement> getAll();

	Departement getById(long id);

	void add(Departement s);

	void delete(long id);

	void modifier(Departement s);
}
