package com.doctorsnote.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doctorsnote.getpatient.GetPatient;
import com.doctorsnote.servlets.path.EndpointPaths;
import com.doctorsnote.servlets.path.PathParser;


@Singleton
public class PatientServlet extends HttpServlet {

  private static final long serialVersionUID = 1346474903324630488L;

  @Inject RequestContext requestContext;
  @Inject GetPatient getPatient;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PathParser pathParser = PathParser.from(EndpointPaths.PATIENT_NOTES, request.getRequestURI());
    requestContext.setPatientId(pathParser.getPathParameter(EndpointPaths.PATIENT_ID));

    getPatient.execute();
  }
}
