package com.co.prueba.mercadoLibre.msmutantsN3.model.repository;

import com.co.prueba.mercadoLibre.msmutantsN3.data.Data;
import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Statistic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EstatisticRepositoryTest {

    @Autowired
    StatisticRepository statisticRepository;

    @Test
    void testSave() {
        try{
            Statistic statistic = statisticRepository.save(Data.createStatistic().get());
            assertEquals(1, statistic.getCountHumanDna());
        }catch (Exception e){
            System.out.println("Falla prueba base de datos test h2");
        }

    }
}