package com.jaydot2.cloud.stream.samplerabbitcloudstream.controller;

import com.jaydot2.cloud.stream.samplerabbitcloudstream.service.MessageHandlerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleStreamController {

    public SampleStreamController(MessageHandlerService mockMessageHandlerService) {
    }

    public ResponseEntity<String> sendMessage(String message) {
        return null;
    }
}
