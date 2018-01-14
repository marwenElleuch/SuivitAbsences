package tn.iit.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {
	public static Date parceDate(String date) {
		Date result = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			result = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("utis" + e.getMessage());
		}
		return result;
	}

	public static String fetchContent(String uri) throws IOException {
		final int OK = 200;
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		int responseCode = connection.getResponseCode();
		if (responseCode == OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			return response.toString();
		}
		return null;
	}
}