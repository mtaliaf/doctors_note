package com.doctorsnote.redis;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnectionPool;
import com.lambdaworks.redis.api.sync.RedisCommands;

public class RedisModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(new TypeLiteral<RedisCommands<String, String>>() {})
        .toProvider(RedisCommandsProvider.class);
  }

  @Provides
  @Singleton
  RedisConnectionPool<RedisCommands<String, String>> provideRedisClient() {
    return RedisClient.create("redis://redis:6379/0")
        .pool();
  }
}
