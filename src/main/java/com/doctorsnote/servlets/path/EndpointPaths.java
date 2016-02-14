package com.doctorsnote.servlets.path;

public class EndpointPaths {
  public static final String DOCTOR_ID = "doctor_id";
  public static final String PATIENT_ID = "patient_id";
  public static final String NOTE_ID = "note_id";

  public static final Path PATIENT_NOTES =
      Path.from(String.format("/patients/{%s}/notes", PATIENT_ID));

  private EndpointPaths() { };
}
