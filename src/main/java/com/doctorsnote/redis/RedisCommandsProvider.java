package com.doctorsnote.redis;

import javax.inject.Inject;
import javax.inject.Provider;

import com.lambdaworks.redis.RedisConnectionPool;
import com.lambdaworks.redis.api.sync.RedisCommands;

public class RedisCommandsProvider implements Provider<RedisCommands<String, String>>{

  private final RedisConnectionPool<RedisCommands<String, String>> connectionPool;

  @Inject
  RedisCommandsProvider(
      RedisConnectionPool<RedisCommands<String, String>> connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public RedisCommands<String, String> get() {
    return connectionPool.allocateConnection();
  }
}
