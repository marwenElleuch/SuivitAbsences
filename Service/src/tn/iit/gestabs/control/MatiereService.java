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

import tn.iit.gestabs.entites.Matiere;
import tn.iit.gestabs.services.MatiereServicesLocal;

@Stateless
@LocalBean
@Path("/matiere")
public class MatiereService {
	@EJB
	private MatiereServicesLocal services;

	public MatiereService() {}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matiere> getAll() {
		return services.getAll();
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void add( Matiere matiere) {
		services.add(matiere);
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Matiere getById(@PathParam("id") Long id) {
		return services.getById(id);
	}	
	
	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void edit(@PathParam("id")Long id,Matiere Matiere) {
		Matiere.setId(id);
		services.modifier(Matiere);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id")Long id) {
		services.delete(id);
	}
	
	
}
