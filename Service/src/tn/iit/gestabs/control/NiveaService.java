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

import tn.iit.gestabs.entites.Niveau;
import tn.iit.gestabs.services.NiveauServicesLocal;

@Stateless
@LocalBean
@Path("/niveau")
public class NiveaService {
	@EJB
	private NiveauServicesLocal sevices;

	public NiveaService() {	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Niveau> getAll() {
		return sevices.getAll();
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void add(Niveau niveau) {
		sevices.add(niveau);
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Niveau getById(@PathParam("id") Long id) {
		return sevices.getById(id);
	}	
	
	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void edit(@PathParam("id")Long id,Niveau niveau) {
		niveau.setId(id);
		sevices.modifier(niveau);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id")Long id) {
		sevices.delete(id);
	}
}
