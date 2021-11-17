package com.co.prueba.mercadoLibre.msmutantsN3.service.estadistic;

import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Statistic;

import java.util.Optional;

public interface StatisticService {


    public Optional<Statistic>findById(Long id);

    public Optional<Statistic> getEstadistic();

    public Statistic save(Statistic statistic);
}
