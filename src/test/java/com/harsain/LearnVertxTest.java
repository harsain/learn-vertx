package com.harsain;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class LearnVertxTest {

  private Vertx vertx;

  @Before
  public void setUp(TestContext context) {
    vertx = Vertx.vertx();
    vertx.deployVerticle(LearnVertx.class.getName(), context.asyncAssertSuccess());
  }

  @After
  public void tearDown(TestContext context) {
    vertx.close(context.asyncAssertSuccess());
  }

  @Test
  public void testThatTheServerIsStarted(TestContext context) {
    Async async = context.async();

    WebClient client = WebClient.create(vertx);

    client
        .get(8080, "localhost", "/")
        .send(
            ar -> {
              HttpResponse<Buffer> response = ar.result();
              context.assertEquals(response.statusCode(), 200);

              context.assertTrue(response.body().length() > 0);
              async.complete();
            });
  }
}
