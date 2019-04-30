package com.jaydot2.cloud.stream.samplerabbitcloudstream.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {

    public static String OUTPUT_CHANNEL = "bray_output_channel";

    @Output(Source.OUTPUT_CHANNEL)
    public MessageChannel outputChannel();
}
