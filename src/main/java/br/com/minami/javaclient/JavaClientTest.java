package br.com.minami.javaclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class JavaClientTest {
	public static void main(String[] args) {
		HttpURLConnection connection = null;
		BufferedReader reader = null;
		try {
			URL url = new URL("http://localhost:8080/exams/laboratory/1");
			url.openConnection();
			
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonSB = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonSB.append(line);
			}
			System.out.println(jsonSB.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(reader);
			if (connection != null) {
				connection.disconnect();
			}
		}
		
	}
}
