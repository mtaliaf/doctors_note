package com.doctors_note.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Singleton
public class PatientNotesServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Map<String, String> variables =
        ServletPaths.PATIENT_NOTES.getVariableToValueMap(request.getRequestURI());
    PrintWriter out = response.getWriter();
    out.println("Request URI: " + request.getRequestURI());
    out.println("Patient ID: " + variables.get(ServletPaths.PATIENT_ID));
    out.close();
  }

}
