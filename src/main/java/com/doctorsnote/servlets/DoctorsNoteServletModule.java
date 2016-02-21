package com.doctorsnote.servlets;

import com.doctorsnote.redis.RedisModule;
import com.doctorsnote.servlets.path.EndpointPaths;
import com.google.inject.Provides;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.ServletModule;

public class DoctorsNoteServletModule extends ServletModule {

  @Override
  protected void configureServlets() {
    install(new RedisModule());

    serveRegex(EndpointPaths.PATIENT_NOTES.getServletPath()).with(PatientNotesServlet.class);
  }

  @Provides
  @RequestScoped
  RequestContext provideRequestContext() {
    return new RequestContext();
  }
}
