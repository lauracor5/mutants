package com.co.prueba.mercadoLibre.msmutantsN2.service;

import com.co.prueba.mercadoLibre.msmutantsN2.data.Data;
import com.co.prueba.mercadoLibre.msmutantsN2.exceptions.ExceptionValidation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MutantServiceTest {

    @Autowired
    MutantService mutantService;


    @Test
    void testIsMutant() {
        String [] dna = Data.createTableDnaMutant();
        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    void testIsNotMutant()  {
        String [] dna = Data.createTableDnaNoMutant();
        assertFalse(mutantService.isMutant(dna));
    }

    @Test
    void testBadData()  {
        String [] dna = Data.createTableDnaBad();
        Exception exception = assertThrows(ExceptionValidation.class, () -> {
            mutantService.isMutant(dna);
        });
        assertEquals("Allowed values(A, T, C, G, C)", exception.getMessage());
    }

}