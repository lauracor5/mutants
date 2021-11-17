package com.co.prueba.mercadoLibre.msmutantsN3.controller;

import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Statistic;
import com.co.prueba.mercadoLibre.msmutantsN3.service.estadistic.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StatiticController {

    @Autowired
    private StatisticService estatisticService;

    @GetMapping("/stats")
    public ResponseEntity<?> stats(){
        Statistic statiticConsult = estatisticService.getEstadistic().get();
        Map<String, Object> response = new HashMap<>();
        response.put("count_mutant_dna", statiticConsult.getCountMutantDna());
        response.put("count_human_dna", statiticConsult.getCountHumanDna());
        response.put("ratio", statiticConsult.getRatio());
        return ResponseEntity.ok().body(response);
    }
}
