package tn.iit.serialize;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import tn.iit.models.EnseignantModel;

public class JsonDeserializerEnseignant implements JsonDeserializer<EnseignantModel> {

	public EnseignantModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		EnseignantModel s = new EnseignantModel();
		JsonObject salleJson = json.getAsJsonObject();
		int id = salleJson.get("id").getAsInt();
		String nom = salleJson.get("nom").getAsString();
		String prenom = salleJson.get("prenom").getAsString();
		String cin = salleJson.get("cin").getAsString();
		String email = salleJson.get("email").getAsString();
		String grade = salleJson.get("grade").getAsString();
		long tel = salleJson.get("tel").getAsLong();
		s.setId(id);
		s.setNom(nom);
		s.setPrenom(prenom);
		s.setCin(cin);
		s.setEmail(email);
		s.setGrade(grade);
		s.setTel(tel);
		return s;
	}

}