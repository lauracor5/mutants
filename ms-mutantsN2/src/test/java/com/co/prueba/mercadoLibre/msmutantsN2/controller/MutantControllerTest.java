package com.co.prueba.mercadoLibre.msmutantsN2.controller;

import com.co.prueba.mercadoLibre.msmutantsN2.data.Data;
import com.co.prueba.mercadoLibre.msmutantsN2.service.MutantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.xml.bind.ValidationException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(MutantController.class)
class MutantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MutantService mutantService;

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
        when(mutantService.isMutant(dna)).thenReturn(false);
        mockMvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isForbidden());
    }
}