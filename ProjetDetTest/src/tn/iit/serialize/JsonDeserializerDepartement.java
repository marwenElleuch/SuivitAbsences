package tn.iit.serialize;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import tn.iit.models.DepartementModel;

public class JsonDeserializerDepartement implements JsonDeserializer<DepartementModel> {

	public DepartementModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		DepartementModel s = new DepartementModel();
		JsonObject salleJson = json.getAsJsonObject();
		int id = salleJson.get("id").getAsInt();
		String nom = salleJson.get("nom").getAsString();
		s.setId(id);
		s.setNom(nom);
		return s;
	}

}