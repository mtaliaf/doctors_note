package com.doctorsnote.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doctors_note.Notes.Note;
import com.doctors_note.Notes.Note.DoctorsOnly;
import com.doctors_note.patient_notes.PatientNotes.PatientNotesResponse;
import com.doctorsnote.servlets.path.EndpointPaths;
import com.doctorsnote.servlets.path.PathParser;
import com.google.common.net.MediaType;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.TimeUtil;


@Singleton
public class PatientNotesServlet extends HttpServlet {

  private static final long serialVersionUID = 5476646525347252649L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PathParser pathParser = PathParser.from(EndpointPaths.PATIENT_NOTES, request.getRequestURI());
    String patientId = pathParser.getPathParameter(EndpointPaths.PATIENT_ID);

    PatientNotesResponse notes = queryNotes(patientId);

    response.setContentType(MediaType.JSON_UTF_8.toString());
    PrintWriter out = response.getWriter();
    out.println(JsonFormat.printer().print(notes));
    out.close();
  }

  private PatientNotesResponse queryNotes(String patientId) {
    return PatientNotesResponse.newBuilder()
        .addNotes(Note.newBuilder()
            .setTimestamp(TimeUtil.getCurrentTime())
            .setBody("Body")
            .setDoctorsOnly(DoctorsOnly.newBuilder()
                .setBody("Doctors Only")
                .build())
            .build())
        .build();
  }
}
