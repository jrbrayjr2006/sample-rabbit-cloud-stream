package com.jaydot2.cloud.stream.samplerabbitcloudstream.controller;

import com.jaydot2.cloud.stream.samplerabbitcloudstream.service.MessageHandlerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SampleStreamControllerTest {

    protected MessageHandlerService mockMessageHandlerService;
    protected MockMvc mockMvc;
    protected SampleStreamController controller;


    @BeforeEach
    void setUp() {
        controller = new SampleStreamController(mockMessageHandlerService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @DisplayName("The sendMessage method should be called with a message is posted to the service")
    @Test
    void shouldCallMessageHandlerService() throws Exception {
        mockMvc.perform(post("/")).andExpect(status().isOk());
        verify(mockMessageHandlerService.sendMessage(any()));
    }

}