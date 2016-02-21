package com.doctorsnote.getpatient;

import static com.google.common.base.Preconditions.checkState;

import java.io.IOException;

import com.doctorsnote.endpoints.GetPatient.GetPatientResponse;
import com.doctorsnote.servlets.RequestContext;
import com.doctorsnote.servlets.ResponseWriter;
import com.google.common.net.MediaType;
import com.google.inject.Inject;
import com.lambdaworks.redis.api.sync.RedisCommands;

public class GetPatient {

  private final RequestContext requestContext;
  private final ResponseWriter responseWriter;
  private final RedisCommands<String, String> commands;

  @Inject
  public GetPatient(
      RequestContext requestContext,
      ResponseWriter responseWriter,
      RedisCommands<String, String> commands) {
    this.requestContext = requestContext;
    this.responseWriter = responseWriter;
    this.commands = commands;
  }

  public void execute() throws IOException {
    checkState(requestContext.getPatientId().isPresent(), "patient_id must be set!");
    responseWriter.write(MediaType.JSON_UTF_8, GetPatientResponse.getDefaultInstance());
  }
}
