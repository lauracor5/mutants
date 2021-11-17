package com.co.prueba.mercadoLibre.msmutantsN3.service.estadistic;

import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Statistic;
import com.co.prueba.mercadoLibre.msmutantsN3.model.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository estatisticRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Statistic> findById(Long id) {
        return estatisticRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Statistic> getEstadistic() {
        List<Statistic> estatiticsRepository = (List<Statistic>) estatisticRepository.findAll();
        if (!estatiticsRepository.isEmpty()) {
            Statistic estatisticUpdate = estatiticsRepository.get(0);
            Optional<Statistic> estatisticOptional = Optional.of(estatisticUpdate);
            return estatisticOptional;
        } else {
            Statistic estatistic = new Statistic();
            estatistic.setId(0L);
            estatistic.setCountHumanDna(0);
            estatistic.setCountMutantDna(0);
            estatistic.setRatio(0.0);
            Optional<Statistic> estatisticOptional = Optional.of(estatistic);
            return estatisticOptional;
        }

    }

    @Override
    @Transactional
    public Statistic save(Statistic statistic) {
        Optional<Statistic> statisticOpt = findById(statistic.getId());
        if (statisticOpt.isEmpty()) {
            Statistic newStatitics = new Statistic();
            newStatitics.setCountMutantDna(statistic.getCountMutantDna());
            newStatitics.setCountHumanDna(statistic.getCountHumanDna());
            if (statistic.getCountHumanDna() != null && statistic.getCountHumanDna() != 0) {
                newStatitics.setRatio((statistic.getCountMutantDna().doubleValue() / statistic.getCountHumanDna().doubleValue()));
            }
            return estatisticRepository.save(newStatitics);
        } else {
            Statistic updateEstadistic = statisticOpt.get();
            updateEstadistic.setCountMutantDna(statistic.getCountMutantDna());
            updateEstadistic.setCountHumanDna(statistic.getCountHumanDna());
            if (statistic.getCountHumanDna() != null && statistic.getCountHumanDna() != 0) {
                updateEstadistic.setRatio((statistic.getCountMutantDna().doubleValue() / statistic.getCountHumanDna().doubleValue()));
            }
            return estatisticRepository.save(updateEstadistic);
        }
    }
}



