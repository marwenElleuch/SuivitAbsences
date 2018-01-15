package tn.iit.util;

import tn.iit.models.SeanceModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

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

	public static String fetchContent2(String uri) {
		final int OK = 200;
		URL url = null;
		try {
			url = new URL(uri);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		int responseCode = 0;
		try {
			responseCode = connection.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		if (responseCode == OK) {
			BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			String inputLine;
			StringBuffer response = new StringBuffer();

			try {
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			return response.toString();
		}
		return null;
	}

}
