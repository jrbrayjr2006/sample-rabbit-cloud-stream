package com.jaydot2.cloud.stream.samplerabbitcloudstream;

import com.jaydot2.cloud.stream.samplerabbitcloudstream.stream.Processor;
import com.jaydot2.cloud.stream.samplerabbitcloudstream.stream.Sink;
import com.jaydot2.cloud.stream.samplerabbitcloudstream.stream.Source;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({Sink.class, Source.class, Processor.class})
@SpringBootApplication
public class SampleRabbitCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleRabbitCloudStreamApplication.class, args);
	}

}
