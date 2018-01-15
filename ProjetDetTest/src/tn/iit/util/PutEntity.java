package tn.iit.util;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;

import javax.ejb.EJB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tn.iit.gestabs.entites.Salle;
import tn.iit.gestabs.entites.Seance;
import tn.iit.gestabs.services.*;
import tn.iit.models.SalleModel;
import tn.iit.models.SeanceModel;

public class PutEntity {
//	@EJB 
//	private SeanceServicesLocal service;
//	@EJB 
//	private SalleServicesLocal salles;
//	@EJB 
//	private NiveauServicesLocal niveaus;
//	@EJB 
//	private MatiereServicesLocal matieres;
//	@EJB 
//	private DepartementServicesLocal depts;
//	@EJB 
//	private EnseignantServicesLocal	enss;
	
	@SuppressWarnings("null")
	public static void updateSeance(long id, String dateSeance, int heureDebut, int heureFin, long salle, long niveau,
			long matiere, long enseignant, long departement) throws IOException {
		String uri = "http://localhost:8080/Service/seance/edit/" + id;
		//System.out.println(id+"************");
		SeanceModel seance = new SeanceModel();
		seance.setId(id);
		seance.setDateSeance(Util.parceDate(dateSeance));
		seance.setHeureDebut(heureDebut);
		seance.setHeureFin(heureFin);
		seance.setSalle(GetEntity.getSalle(salle));
		seance.setDepartement(GetEntity.getDepartement(departement));
		seance.setEnseignant(GetEntity.getEnseignant(enseignant));
		seance.setMatiere(GetEntity.getMatiere(matiere));
		seance.setNiveau(GetEntity.getNiveau(niveau));
		
		Gson gson = new GsonBuilder().create();
		String seanceJson = gson.toJson(seance);

		 URL url = new URL(uri);
		 HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		 httpCon.setDoOutput(true);
		 //httpCon.setDoInput(true);
		 httpCon.setRequestMethod("PUT");
		 httpCon.setRequestProperty("Content-Type", "application/json; charset=utf8");
		 httpCon.setRequestProperty("Accept", "application/json");
		 DataOutputStream out = new	 DataOutputStream(httpCon.getOutputStream());
		 out.writeBytes(seanceJson);
		 System.out.println(out);
		 out.close();
		 httpCon.getInputStream();
		
//		URL url = new URL(uri);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		connection.setDoOutput(true);
//		connection.setInstanceFollowRedirects(false);
//		connection.setRequestProperty("Accept", "application/json");
//		connection.setRequestProperty("Content-Type", "application/json; charset=utf8");
//		connection.setRequestMethod("PUT");
//		OutputStream os = connection.getOutputStream();
//		os.write(seanceJson.getBytes());
//		System.out.println(os);
//		os.flush();
//		int a = connection.getResponseCode();
//		if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//			throw new RuntimeException("Failed to create customer");
//		}
//
//		System.out.println("Location: " + connection.getHeaderField("Location"));
//		connection.disconnect();
		//updateSeance2(id, dateSeance, heureDebut, heureFin, salle, niveau, matiere, enseignant, departement);
	}

	public static void updateSalle(long id, String nom) {
		String uri = "http://localhost:8080/Service/salle/edit/" + id;
		SalleModel s = new SalleModel();
		s.setId(id);
		s.setNom(nom);

	}
	public void updateSeance2(long id, String dateSeance, int heureDebut, int heureFin, long salle, long niveau,
			long matiere, long enseignant, long departement) throws IOException {
		String uri = "http://localhost:8080/Service/seance/edit/" + id;
		//System.out.println(id+"************");
		Seance seance = new Seance();
		seance.setId(id);
		//seance.setDateSeance((Date) Util.parceDate(dateSeance));
		seance.setHeureDebut(heureDebut);
		seance.setHeureFin(heureFin);
//		seance.setSalle(salles.getById(salle));
//		seance.setDepartement(depts.getById(departement));
//		seance.setEnseignant(enss.getById(enseignant));
//		seance.setMatiere(matieres.getById(matiere));
//		seance.setNiveau(niveaus.getById(niveau));
//		service.modifier(seance);

	}

	
}
