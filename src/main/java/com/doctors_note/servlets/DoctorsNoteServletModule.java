package com.doctors_note.servlets;

import com.doctorsnote.redis.RedisModule;
import com.doctorsnote.servlets.path.EndpointPaths;
import com.google.inject.servlet.ServletModule;

public class DoctorsNoteServletModule extends ServletModule {

  @Override
  protected void configureServlets() {
    install(new RedisModule());

    serveRegex(EndpointPaths.PATIENT_NOTES.getServletPath()).with(PatientNotesServlet.class);
  }
}
