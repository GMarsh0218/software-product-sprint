package com.google.sps.servlets;


import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact-form-handler")
public class ContactHandlerServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		// Get values from the form
		String name = request.getParameter("name-input");
		String email = request.getParameter("email-input");
		String message = request.getParameter("message-input");

		// Print message successful message received!
		System.out.println("New Message Received from " + name + "(" + email + ")":);
		System.out.println(message);


	}
}
