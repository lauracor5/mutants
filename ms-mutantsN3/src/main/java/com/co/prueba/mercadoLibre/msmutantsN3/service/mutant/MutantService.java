package com.co.prueba.mercadoLibre.msmutantsN3.service.mutant;


import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Mutant;

import java.util.Optional;

public interface MutantService {

    boolean isMutant(String[]dna);

    Optional<Mutant>findByDna(String dna);

    Mutant save(String[]dna);
}
