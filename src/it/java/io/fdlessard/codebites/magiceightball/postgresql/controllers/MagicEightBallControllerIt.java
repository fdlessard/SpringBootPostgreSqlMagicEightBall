package io.fdlessard.codebites.magiceightball.postgresql.controllers;

import io.fdlessard.codebites.magiceightball.postgresql.SpringBootPostgreSqlMagicEightBallApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {SpringBootPostgreSqlMagicEightBallApplication.class})
@ActiveProfiles("integration")
@AutoConfigureMockMvc
class MagicEightBallControllerIt {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MagicEightBallController magicEightBallController;

    @BeforeEach
    void beforeEach() {
    }

    @Test
    void isAlive() throws Exception {

        mockMvc.perform(get("/magiceightball/isAlive").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("MagicEightBallController is alive")));
    }

    @Test
    void shake() throws Exception {

        mockMvc.perform(get("/magiceightball/shake").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasKey("id")))
                .andExpect(jsonPath("$", hasKey("message")))
                .andExpect(jsonPath("$", hasKey("color")));
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/magiceightball/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(20)));
    }
}