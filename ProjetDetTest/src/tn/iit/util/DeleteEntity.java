package tn.iit.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteEntity {
	
	public static void deleteSeance(long id) throws IOException {
		URL url = new URL("http://localhost:8080/Service/seance/delete/"+id);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestProperty("Content-Type", "application/json");
		httpCon.setRequestMethod("DELETE");
		httpCon.connect();
		int responseCode = httpCon.getResponseCode();
		if (responseCode == 204) {
			System.out.println("succes..");
		}
	}
	
	public static void deleteSalle(long id) throws IOException {
		URL url = new URL("http://localhost:8080/Service/salle/delete/"+id);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestProperty("Content-Type", "application/json");
		httpCon.setRequestMethod("DELETE");
		httpCon.connect();
		int responseCode = httpCon.getResponseCode();
		if (responseCode == 204) {
			System.out.println("succes..");
		}
	}
	
}
