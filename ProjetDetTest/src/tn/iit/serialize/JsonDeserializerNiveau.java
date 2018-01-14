package tn.iit.serialize;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import tn.iit.models.NiveauModel;

public class JsonDeserializerNiveau implements JsonDeserializer<NiveauModel> {

	public NiveauModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		NiveauModel niveau = new NiveauModel();
		JsonObject salleJson = json.getAsJsonObject();
		int id = salleJson.get("id").getAsInt();
		String filiere = salleJson.get("filiere").getAsString();
		int annee = salleJson.get("annee").getAsInt();
		niveau.setId(id);
		niveau.setFiliere(filiere);
		niveau.setAnnee(annee);
		return niveau;
	}

}