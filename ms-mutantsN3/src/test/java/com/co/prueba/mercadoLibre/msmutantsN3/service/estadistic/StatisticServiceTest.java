package com.co.prueba.mercadoLibre.msmutantsN3.service.estadistic;

import com.co.prueba.mercadoLibre.msmutantsN3.data.Data;
import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Statistic;
import com.co.prueba.mercadoLibre.msmutantsN3.model.repository.MutantRepository;
import com.co.prueba.mercadoLibre.msmutantsN3.model.repository.StatisticRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatisticServiceTest {

    @MockBean
    StatisticRepository statisticRepository;

    @Autowired
    StatisticService statisticService;

    @Test
    void testFindById() {
        when(statisticRepository.findById(1L)).thenReturn(Data.createStatistic());
        Statistic statistic = statisticService.findById(1L).get();
        assertEquals(2, statistic.getCountMutantDna());
    }

    @Test
    void testGetStatistic() {
        when(statisticRepository.findAll()).thenReturn(Data.staticList());
        Statistic statistic = statisticService.getEstadistic().get();
        assertEquals(2, statistic.getCountMutantDna());
    }

    @Test
    void testSave() {
        Statistic newStatistic = Data.createStatistic().get();
        when(statisticRepository.save(any())).then(invocation -> {
            Statistic s = invocation.getArgument(0);
            s.setId(1L);
            return s;
        });
        Statistic statistic = statisticService.save(newStatistic);
        assertEquals(2, statistic.getCountMutantDna());

    }
}