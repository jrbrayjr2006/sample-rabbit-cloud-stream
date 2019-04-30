package com.jaydot2.cloud.stream.samplerabbitcloudstream.service;

import com.jaydot2.cloud.stream.samplerabbitcloudstream.stream.Sink;
import com.jaydot2.cloud.stream.samplerabbitcloudstream.stream.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageHandlerService implements MessageHandler {

    private final Source source;
    private final Sink sink;

    public MessageHandlerService(Source source, Sink sink) {
        this.source = source;
        this.sink = sink;
    }

    @SendTo(Source.OUTPUT_CHANNEL)
    public String sendMessage(String message) {
        Message<String> payload = MessageBuilder.withPayload(message).build();
        source.outputChannel().send(payload);
        return payload.getPayload();
    }

    @Input(Sink.INPUT_CHANNEL)
    public String consumeMessages() {
        log.debug("messages");
        MessageHandler handler = null;
        //sink.inputChannel().subscribe(this);
        return "";
    }

    @SendTo(Sink.INPUT_CHANNEL)
    @StreamListener(Source.OUTPUT_CHANNEL)
    public String processMessages() {
        log.debug("processing");
        return "";
    }

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {

    }
}
