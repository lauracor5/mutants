package com.co.prueba.mercadoLibre.msmutantsN3.controller;

import com.co.prueba.mercadoLibre.msmutantsN3.data.Data;
import com.co.prueba.mercadoLibre.msmutantsN3.service.estadistic.StatisticService;
import com.co.prueba.mercadoLibre.msmutantsN3.service.mutant.MutantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MutantController.class)
class MutantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MutantService mutantService;

    @MockBean
    private StatisticService statisticService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testIsMutant() throws Exception {
        Map<String, Object> request = new HashMap<>();
        String[]dna = Data.createTableDnaMutant();
        request.put("dna", dna);
        when(statisticService.getEstadistic()).thenReturn(Data.createStatistic());
        when(statisticService.save(Data.createStatistic().get())).thenReturn(Data.createStatistic().get());
        when(mutantService.isMutant(dna)).thenReturn(true);
        mockMvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void testIsNotMutant() throws Exception {
        Map<String, Object> request = new HashMap<>();
        String[]dna = Data.createTableDnaNoMutant();
        request.put("dna", dna);
        when(statisticService.getEstadistic()).thenReturn(Data.createStatistic());
        when(statisticService.save(Data.createStatistic().get())).thenReturn(Data.createStatistic().get());
        when(mutantService.isMutant(dna)).thenReturn(false);
        mockMvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isForbidden());
    }
}