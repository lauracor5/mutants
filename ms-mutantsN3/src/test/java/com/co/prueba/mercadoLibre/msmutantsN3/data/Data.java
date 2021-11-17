package com.co.prueba.mercadoLibre.msmutantsN3.data;

import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Mutant;
import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Statistic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Data {

    static int longTable = 6;

    public static String[] createTableDnaMutant() {
        String[] table =
                {"ATGCGG", "CAGTGC", "TTATGT", "AGAAGG", "CCCTTA", "TCACTG"};
        return table;
    }

    public static String[] createTableDnaNoMutant() {
        String[] table =
                {"ATGCTA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        return table;
    }

    public static String[] createTableDnaBad() {
        String[] table =
                {"ATGCTA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTK"};
        return table;
    }

    public static Optional<Statistic> createStatistic(){
        Statistic statistic = new Statistic();
        statistic.setId(1L);
        statistic.setCountHumanDna(1);
        statistic.setCountMutantDna(2);
        statistic.setRatio(1.5);
        Optional<Statistic> statisticOpt = Optional.of(statistic);
        return statisticOpt;
    }

    public static Optional<Mutant> createMutant(){
        Mutant mutant = new Mutant();
        mutant.setId(1L);
        mutant.setDna("ATGCGGCAGTGCTTATGTAGAAGGCCCTTATCACTG");
        Optional<Mutant>mutantOpt = Optional.of(mutant);
        return mutantOpt;
    }

    public static List<Statistic> staticList(){
        List<Statistic>statistics = new ArrayList<>();
        statistics.add(createStatistic().get());
        return statistics;
    }

}
