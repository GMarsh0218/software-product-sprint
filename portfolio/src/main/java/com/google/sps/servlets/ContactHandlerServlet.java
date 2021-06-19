package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact-form-handler")
public class ContactHandlerServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		// Get values from the form
		String name = request.getParameter("");

	}
}
