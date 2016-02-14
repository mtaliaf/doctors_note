package com.doctorsnote.getpatients;

import com.google.inject.Inject;
import com.lambdaworks.redis.api.sync.RedisCommands;

public class GetPatient {

  private final RedisCommands<String, String> commands;

  @Inject
  public GetPatient(RedisCommands<String, String> commands) {
    this.commands = commands;
  }

  public GetPatientResponse execute() {

  }
}
