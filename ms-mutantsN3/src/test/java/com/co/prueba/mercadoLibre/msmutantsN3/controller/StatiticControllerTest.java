package com.co.prueba.mercadoLibre.msmutantsN3.controller;

import com.co.prueba.mercadoLibre.msmutantsN3.data.Data;
import com.co.prueba.mercadoLibre.msmutantsN3.service.estadistic.StatisticService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StatiticController.class)
class StatiticControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatisticService statisticService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void stats() throws Exception{
        when(statisticService.getEstadistic()).thenReturn(Data.createStatistic());
        mockMvc.perform(get("/stats").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}