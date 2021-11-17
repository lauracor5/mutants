package com.co.prueba.mercadoLibre.msmutantsN3.model.repository;

import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Mutant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MutantRepository extends CrudRepository<Mutant, Long> {

    Optional<Mutant> findByDna(String dna);
}
