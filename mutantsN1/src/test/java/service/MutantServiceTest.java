package service;

import data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutantServiceTest {

    MutantService mutantService;

    @BeforeEach
    void setUp() {
        mutantService = new MutantServiceimpl();
    }
    @Test
    void isMutant() {
        String[]dna = Data.createTableDnaMutant();
        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    void testIsNotMutant() {
        String[]dna = Data.createTableDnaNoMutant();
        assertFalse(mutantService.isMutant(dna));
    }
}