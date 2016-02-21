package com.doctorsnote.redis;

import com.google.inject.Inject;
import com.lambdaworks.redis.api.sync.RedisCommands;

public class RedisGet {

  private final RedisCommands<String, String> commands;

  @Inject
  public RedisGet(RedisCommands<String, String> commands) {
    this.commands = commands;
  }

  public String execute(String key) {
    String value = commands.get(key);
    commands.close();

    return value;
  }
}
