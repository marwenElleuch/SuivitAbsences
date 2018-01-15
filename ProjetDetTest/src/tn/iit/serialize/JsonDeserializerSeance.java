package tn.iit.serialize;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import tn.iit.models.DepartementModel;
import tn.iit.models.EnseignantModel;
import tn.iit.models.MatiereModel;
import tn.iit.models.NiveauModel;
import tn.iit.models.SalleModel;
import tn.iit.models.SeanceModel;
import tn.iit.util.Util;

public class JsonDeserializerSeance implements JsonDeserializer<SeanceModel> {

	public SeanceModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		SeanceModel s = new SeanceModel();
		Date date = null;
		JsonObject seanceJson = json.getAsJsonObject();
		int id = seanceJson.get("id").getAsInt();
		int heureDebut = seanceJson.get("heureDebut").getAsInt();
		int heureFin = seanceJson.get("heureFin").getAsInt();
		String dateSeance = seanceJson.get("dateSeance").getAsString();
		System.out.println(dateSeance);
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//date = format.parse(dateSeance);
		s.setDateSeance(Util.parceDate(dateSeance));
		
		JsonObject se = seanceJson.get("salle").getAsJsonObject();
		SalleModel salle = new JsonDeserializerSalle().deserialize(se, typeOfT, context);

		JsonObject niveaujson = seanceJson.get("niveau").getAsJsonObject();
		NiveauModel niveau = new JsonDeserializerNiveau().deserialize(niveaujson, typeOfT, context);

		JsonObject matiereJSON = seanceJson.get("matiere").getAsJsonObject();
		MatiereModel matiere = new JsonDeserializerMatiere().deserialize(matiereJSON, typeOfT, context);

		JsonObject enseignantJson = seanceJson.get("enseignant").getAsJsonObject();
		EnseignantModel enseignant = new JsonDeserializerEnseignant().deserialize(enseignantJson, typeOfT, context);

		JsonObject departementJson = seanceJson.get("departement").getAsJsonObject();
		DepartementModel departement = new JsonDeserializerDepartement().deserialize(departementJson, typeOfT, context);

		s.setId(id);
		//s.setDateSeance(date);
		s.setHeureDebut(heureDebut);
		s.setHeureFin(heureFin);
		s.setSalle(salle);
		s.setDepartement(departement);
		s.setEnseignant(enseignant);
		s.setMatiere(matiere);
		s.setNiveau(niveau);
		return s;
	}

}