package com.doctors_note.servlets;

public class ServletPaths {
  public static final String DOCTOR_ID = "doctor_id";
  public static final String PATIENT_ID = "patient_id";
  public static final String NOTE_ID = "note_id";

  public static final ServletPath PATIENT_NOTES =
      ServletPath.from(String.format("/patients/{%s}/notes", PATIENT_ID));
}
