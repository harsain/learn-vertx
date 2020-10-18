package com.harsain;

import io.vertx.core.AbstractVerticle;

public class LearnVertx extends AbstractVerticle {

  @Override
  public void start() {

    vertx.createHttpServer().requestHandler(req -> req.response().end("Hello Vertx!")).listen(8080);
  }
}
