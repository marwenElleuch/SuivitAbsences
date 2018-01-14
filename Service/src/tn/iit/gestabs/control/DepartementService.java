package tn.iit.gestabs.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.iit.gestabs.entites.Departement;
import tn.iit.gestabs.services.DepartementServicesLocal;

@Stateless
@LocalBean
@Path("/departement")
public class DepartementService {
	@EJB
	private DepartementServicesLocal services;

	public DepartementService() {
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Departement> getAll() {
		return services.getAll();
	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void add(Departement departement) {
		services.add(departement);
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Departement getById(@PathParam("id") Long id) {
		return services.getById(id);
	}

	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void edit(@PathParam("id") Long id, Departement departement) {
		departement.setId(id);
		services.modifier(departement);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") Long id) {
		services.delete(id);
	}
}
