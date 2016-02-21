package com.doctorsnote.servlets;

import com.google.common.base.Optional;

public class RequestContext {
  private Optional<String> doctorId = Optional.absent();
  private Optional<String> patientId = Optional.absent();
  private Optional<String> noteId = Optional.absent();

  public Optional<String> getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId = Optional.of(doctorId);
  }

  public Optional<String> getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = Optional.of(patientId);
  }

  public Optional<String> getNoteId() {
    return noteId;
  }

  public void setNoteId(String noteId) {
    this.noteId = Optional.of(noteId);
  }
}
