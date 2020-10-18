Vertx

# Intro

Eclipse Vert.x is a toolkit for buildign reactive applications on the JVM.

Vert.x is not a framework but a toolkit. Core library defines the fundamental APIs for writing asynchronous networked applications, and then we can pick the useful modules for your application (e.g., database connection, monitoring, authentication, logging, service discovery, clustering support, etc).


Vert.x doesnt impose any packaging or build packaging. Since Vert.x core itself is just a regular jar library it can be embedded inside applications packaged as aset of Jars with all dependencies.

Vert.x is polyglot as it supports a wide range of popular JVM languages: Java, Groovy, Scala, Kotlin, JavaScript, Ruby and Ceylon. 

# Core Concepts

- Verticle
- Event Bus (which allows the veticles to communciate)

The unit of deployment in Vert.x is called a Verticle. A Verticle processes incoming events over an _event-loop_, where events can be anything like receiving network buffers, timing events or messages sent by other verticles.

Each event shall be processed in a reasonable amount of time to not block the event loop. This means that thread blocking operations shall not be performed while executed on the event loop, exactly like processing events in a graphical user interface (e.g., freezing a Java / Swing interface by doing a slow network request).

Vert.x offers mechanisms to deal with blocking operations outside of the event loop.
Multiple Verticles instances can be deployed. 
The _Event-Bus_ allows passing any kind of data, although JSON is the preferred exchange format since it allows verticles written in different languages to communicate.
### Communication patterns:
- point-to-point messaging
- request-response messaging
- publish/subscribe for broadcasting messages


Reactive systems

- Responsive
- Resilient
- Elastic
- Message-Driven

### start a new project

```bash
mvn io.reactiverse:vertx-maven-plugin:1.0.23:setup \
    -DprojectGroupId=com.harsain \
    -DprojectArtifactId=learn-vertx \
    -DprojectVersion=1.0-SNAPSHOT \
    -Dverticle=com.harsain.LearnVertx
```

### useful links

[vertx docs](https://vertx.io/docs/#core)

[https://vertx.io/docs/kdoc/vertx/io.vertx.reactivex.core/index.html](https://vertx.io/docs/kdoc/vertx/io.vertx.reactivex.core/index.html)

[Vert.x maven starter](https://github.com/vert-x3/vertx-maven-starter)

[vertx-springboot-realworld-example-app](https://github.com/diegocamara/vertx-springboot-realworld-example-app)

[gothinkster realworld](https://github.com/gothinkster/realworld)

[gothinkster realworld api](https://github.com/gothinkster/realworld/tree/master/api)

[gothinkster realworld-starter-kit](https://github.com/gothinkster/realworld-starter-kit)

[From Zero to Back End in 45 mins with Vert.x](https://www.youtube.com/watch?v=3_CRKfs4Zzo&t=0s)