package com.jaydot2.cloud.stream.samplerabbitcloudstream.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Processor {

    public static String FITNESS_INPUT_CHANNEL = "fitness_input_channel";

    public static String STRENGTH_OUTPUT_CHANNEL = "strength_output_channel";

    public static String CARDIO_OUTPUT_CHANNEL = "cardio_output_channel";

    @Input(Processor.FITNESS_INPUT_CHANNEL)
    public SubscribableChannel fitnessInputChannel();

    @Output
    public MessageChannel strengthOutputChannel();

    @Output
    public MessageChannel cardioOutputChannel();
}
