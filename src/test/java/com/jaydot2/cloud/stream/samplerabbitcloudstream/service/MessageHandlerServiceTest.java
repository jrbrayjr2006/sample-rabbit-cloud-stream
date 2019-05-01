package com.jaydot2.cloud.stream.samplerabbitcloudstream.service;

import com.jaydot2.cloud.stream.samplerabbitcloudstream.stream.Sink;
import com.jaydot2.cloud.stream.samplerabbitcloudstream.stream.Source;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MessageHandlerServiceTest {

    private Source mockSource;
    private Sink mockSink;
    protected MessageHandlerService service;

    @BeforeEach
    void setUp() {
        mockSource = mock(Source.class);
        service = new MessageHandlerService(mockSource, mockSink);
    }

    @DisplayName("Given a message, when sendMessage is called, the payload should contain the message")
    @Test
    void shouldHaveMessageInPayload() {
        // Given
        String message = "hello";
        Message<String> messagePayload = MessageBuilder.withPayload(message).build();
        MessageChannel mockMessageChannel = mock(MessageChannel.class);
        // When
        when(mockSource.outputChannel()).thenReturn(mockMessageChannel);
        String actual = service.sendMessage(message);
        // Then
        assertEquals(message, actual);
    }

    @DisplayName("Given a message payload, when a message is sent, then the output channel should process it")
    @Test
    void shouldSendMessageToOutputChannel() {
        // Given
        String message = "hello";
        Message<String> messagePayload = MessageBuilder.withPayload(message).build();
        MessageChannel mockMessageChannel = mock(MessageChannel.class);
        // When
        when(mockSource.outputChannel()).thenReturn(mockMessageChannel);
        String actual = service.sendMessage(message);
        // Then
        verify(mockSource.outputChannel()).send(any(Message.class));
    }

    void shouldProcessIncomingMessages() {
        // Given

        // When

        // Then
    }
}