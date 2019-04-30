package com.jaydot2.cloud.stream.samplerabbitcloudstream.controller;

import com.jaydot2.cloud.stream.samplerabbitcloudstream.service.MessageHandlerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleStreamController {

    protected MessageHandlerService messageHandlerService;

    public SampleStreamController(MessageHandlerService messageHandlerService) {
        this.messageHandlerService = messageHandlerService;
    }

    @PostMapping( value = "/{message}" )
    public ResponseEntity<String> sendMessage(@PathVariable String message) {
        ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
        messageHandlerService.sendMessage(message);
        return response;
    }
}
