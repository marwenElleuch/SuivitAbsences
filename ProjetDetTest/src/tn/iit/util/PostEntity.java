package tn.iit.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.HttpMethod;
import javax.wsdl.extensions.http.HTTPAddress;
import javax.wsdl.extensions.http.HTTPOperation;
import javax.xml.ws.http.HTTPBinding;

import org.jboss.resteasy.util.HttpClient4xUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tn.iit.models.SeanceModel;

public class PostEntity {

	public static void ajoutSeance(String dateSeance, int heureDebut, int heureFin, long salle, long niveau,
			long matiere, long enseignant, long departement) throws IOException {

		SeanceModel seance = new SeanceModel();
		seance.setDateSeance(Util.parceDate(dateSeance));
		seance.setHeureDebut(heureDebut);
		seance.setHeureFin(heureFin);
		seance.setSalle(GetEntity.getSalle(salle));
		seance.setDepartement(GetEntity.getDepartement(departement));
		seance.setEnseignant(GetEntity.getEnseignant(enseignant));
		seance.setMatiere(GetEntity.getMatiere(matiere));
		seance.setNiveau(GetEntity.getNiveau(niveau));
		String uri = "http://localhost:8080/Service/seance/add/" + seance;
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		gson.toJson(seance);
		
		

	}


}
