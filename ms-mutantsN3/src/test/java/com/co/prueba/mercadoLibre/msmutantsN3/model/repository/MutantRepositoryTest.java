package com.co.prueba.mercadoLibre.msmutantsN3.model.repository;

import com.co.prueba.mercadoLibre.msmutantsN3.data.Data;
import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Mutant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MutantRepositoryTest {

    @Autowired
    MutantRepository mutantRepository;

    @Test
    void testSave() {
        try{

            Mutant newMutant = mutantRepository.save(Data.createMutant().get());
            assertEquals("ATGCGGCAGTGCTTATGTAGAAGGCCCTTATCACTG", newMutant.getDna());
        }catch (Exception e){
            System.out.println("Falla prueba base de datos test h2");
        }
    }
}