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

import tn.iit.gestabs.entites.Salle;
import tn.iit.gestabs.services.SalleServicesLocal;

@Stateless
@LocalBean
@Path("/salle")
public class SalleService {
	@EJB
	private SalleServicesLocal sevices;

	public SalleService() {	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Salle> getAll() {
		return sevices.getAll();
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void add(Salle salle) {
		sevices.add(salle);
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Salle getById(@PathParam("id") Long id) {
		return sevices.getById(id);
	}	
	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void edit(@PathParam("id")Long id,Salle salle) {
		salle.setId(id);
		sevices.modifier(salle);		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") long id) {
		sevices.delete(id);
	}
	
}
