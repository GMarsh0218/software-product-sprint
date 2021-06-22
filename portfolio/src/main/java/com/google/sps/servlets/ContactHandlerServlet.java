package com.google.sps.servlets;


import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact-form-handler")
public class ContactHandlerServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		// Get values from the form
		String name = request.getParameter("name-input");
		String email = request.getParameter("email-input");
		String message = request.getParameter("message-input");

		// Print message successful message received!
		System.out.println("New Message Received from " + name + "(" + email + "):");
		System.out.println(message);

		//redirect to homepage
		try {
			response.sendRedirect("/index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
