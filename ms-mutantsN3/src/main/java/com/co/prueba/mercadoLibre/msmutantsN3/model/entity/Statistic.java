package com.co.prueba.mercadoLibre.msmutantsN3.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "statistics")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count_mutant_dna")
    private Integer countMutantDna;

    @Column(name = "count_human_dna")
    private Integer countHumanDna;

    private Double ratio;


}
