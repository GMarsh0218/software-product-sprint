package com.google.sps.servlets;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getRecentlyPlayed")
public class RecentlyPlayedServlet extends HttpServlet {

	public static final String LASTFM_API_URI = "https://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user=gmarsh0218&api_key=a228b6b2b58f233537d93206e9b768c5&format=json&limit=1";

	public static String getAPIResponse(String uri) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
						.GET()
						.header("accept", "application/json")
						.uri(URI.create(uri))
						.build();
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return response.body();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;");
		response.getWriter().println("<p>" + getAPIResponse(LASTFM_API_URI) + "</p>");
	}




}
