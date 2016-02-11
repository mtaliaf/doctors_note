package com.doctors_note.servlets;

import javax.servlet.annotation.WebListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

@WebListener
public class DoctorsNoteServletConfig extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new ServletModule() {
      @Override
      protected void configureServlets() {
        serveRegex(ServletPaths.PATIENT_NOTES.getServletPath()).with(PatientNotesServlet.class);
      }
    });
  }
}