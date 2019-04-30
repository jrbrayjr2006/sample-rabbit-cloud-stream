package com.jaydot2.cloud.stream.samplerabbitcloudstream.controller;


import com.jaydot2.cloud.stream.samplerabbitcloudstream.service.MessageHandlerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class SampleStreamControllerTest {

    protected MessageHandlerService mockMessageHandlerService;
    protected MockMvc mockMvc;
    protected SampleStreamController controller;


    @BeforeEach
    void setUp() {
        mockMessageHandlerService = mock(MessageHandlerService.class);
        controller = new SampleStreamController(mockMessageHandlerService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @DisplayName("The sendMessage method should be called with a message is posted to the service")
    @Test
    void shouldCallMessageHandlerService() throws Exception {
        // When
        mockMvc.perform(post("/hello")).andExpect(status().isOk());
        // Then
        verify(mockMessageHandlerService).sendMessage("hello");
    }

}