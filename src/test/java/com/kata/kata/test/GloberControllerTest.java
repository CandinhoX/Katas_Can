package com.kata.kata.test;

import com.kata.kata.controller.GloberController;
import com.kata.kata.dto.GloberInfoDTO;
import com.kata.kata.service.GloberService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GloberController.class)
class GloberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private GloberService globerService;

    @Test
    void getGloberInfo() throws Exception {
        when(globerService.getGloberInfo(1)).thenReturn(
                new GloberInfoDTO("test@company.com", "Test User", List.of(), List.of())
        );

        mockMvc.perform(get("/api/globers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@company.com"));
    }
}