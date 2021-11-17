package com.co.prueba.mercadoLibre.msmutantsN3.service.mutant;
import com.co.prueba.mercadoLibre.msmutantsN3.data.Data;
import com.co.prueba.mercadoLibre.msmutantsN3.exceptions.ExceptionValidation;
import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Mutant;
import com.co.prueba.mercadoLibre.msmutantsN3.model.repository.MutantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class MutantServiceTest {

    @MockBean
    MutantRepository mutantRepository;

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

    @Test
    void testSaveMutant() {
        String [] dna = Data.createTableDnaMutant();
        when(mutantRepository.save(any())).then(invocation -> {
            Mutant m = invocation.getArgument(0);
            m.setId(1L);
            return m;
        });
        Mutant mutant = mutantService.save(dna);
        assertEquals("ATGCGGCAGTGCTTATGTAGAAGGCCCTTATCACTG", mutant.getDna());
    }

    @Test
    void testfindByDna() {
        when(mutantRepository.findByDna("ATGCGGCAGTGCTTATGTAGAAGGCCCTTATCACTG")).thenReturn(Data.createMutant());
        Mutant mutant = mutantService.findByDna("ATGCGGCAGTGCTTATGTAGAAGGCCCTTATCACTG").get();
        assertEquals("ATGCGGCAGTGCTTATGTAGAAGGCCCTTATCACTG", mutant.getDna() );
    }
}