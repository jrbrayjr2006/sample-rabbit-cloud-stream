package com.jaydot2.cloud.stream.samplerabbitcloudstream.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {

    public static String INPUT_CHANNEL = "bray_input_channel";

    @Input(Sink.INPUT_CHANNEL)
    public SubscribableChannel inputChannel();
}
