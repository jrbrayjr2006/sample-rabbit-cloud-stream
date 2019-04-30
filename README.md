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