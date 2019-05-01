# Sample Rabbit Cloud Stream

## Purpose
Provide an example implementation of Spring Cloud Streams using RabbitMQ.

## Setup

### Setup RabbitMQ Docker Image

Get the RabbitMQ docker image:  `docker pull rabbitmq`.

Run the RabbitMQ docker image.

```cmd
docker run -d --hostname localhost --name bray-rabbit -p 15672:15672 -p 5672:5672 -p 5671:5671 rabbitmq:3-management
```

## Implementation

This imnplementation of Spring Cloud Streams uses interfaces to setup the `MessageChannel` and `SubscribableChannel`.

### Sending Messages

Messages can be sent using as `MessageChannel`.

```java
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {

    public static String OUTPUT_CHANNEL = "jaydot2_output_channel";

    @Output(Source.OUTPUT_CHANNEL)
    public MessageChannel outputChannel();
}
```

### Receiving Messages


### Binding the Interfaces

The interfaces which specify the input and output channels must be bound to the Spring Boot application in order to instantiate beans for them.  The `@EnableBinding` annotation is used for this on the Application class of the Spring Boot application.

```java
@EnableBinding({Sink.class, Source.class, Processor.class})
@SpringBootApplication
public class SampleRabbitCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleRabbitCloudStreamApplication.class, args);
	}

}
```

## Configuration

Spring Cloud Streams can be configured using code, properties, XML, or YAML files. At the time of the writing of this document, YAML is the preferred configuration option.

**Example:**
```yaml
spring:
  cloud:
    stream:
      bindings:
        jaydot2_input_channel:
          destination: jaydot2.input.channel
          binder: local_rabbit
          group: bray
        jaydot2_output_channel:
          destination: jaydot2.output.channel
          binder: local_rabbit
        fitness_input_channel:
          destination: fitness.input.channel
          binder: local_rabbit
          group: exercises
        strength_output_channel:
          destination: strength.output.channel
          binder: local_rabbit
          group: strength
      binders:
        local_rabbit:
          type: rabbit
          environment:
            spring:
              rabbitmq:
                host: localhost
                port: 5672
                username: guest
                password: guest
```

The `binders` section describes the binding to message queue platform, such as RabbitMQ, Solace, etc.

The `bindings` section describes the channels, topics, and/or groups that are bound.  If no group is specified for an input channel, an anonymous one is created by default.

**Note** a queue is only automatically created when there is a subscriber/consumer for that queue.

## Testing

### Gradle Testing Dependencies

When using JUnit 5 with IntelliJ and Java 11.x, use the `org.junit.jupiter:junit-jupiter` dependency to avoid errors running unit tests in IntelliJ. 

```groovy
dependencies {
	...
	...
	testImplementation ('org.springframework.boot:spring-boot-starter-test',
						// Spring Cloud Stream Testing
						'org.springframework.cloud:spring-cloud-stream-test-support',
						// Junit 5 Jupiter
						'org.junit.jupiter:junit-jupiter',
						'org.mockito:mockito-junit-jupiter')
}
```

## References

- [Spring Cloud Stream](http://cloud.spring.io/spring-cloud-static/spring-cloud-stream/2.1.2.RELEASE/single/spring-cloud-stream.html#spring-cloud-stream-overview-introducing)
- [Spring Cloud Stream Implementation](https://github.com/spring-cloud/spring-cloud-stream-binder-rabbit)
- [Introduction to Spring Cloud Stream](https://www.baeldung.com/spring-cloud-stream)
- [Setting up RabbitMQ with Spring Cloud Stream](https://www.e4developer.com/2018/01/28/setting-up-rabbitmq-with-spring-cloud-stream/)
- [RabbitMQ Docker Image](https://hub.docker.com/_/rabbitmq)