package com.co.prueba.mercadoLibre.msmutantsN3.controller;

import com.co.prueba.mercadoLibre.msmutantsN3.exceptions.ExceptionValidation;
import com.co.prueba.mercadoLibre.msmutantsN3.model.entity.Statistic;
import com.co.prueba.mercadoLibre.msmutantsN3.service.estadistic.StatisticService;
import com.co.prueba.mercadoLibre.msmutantsN3.service.mutant.MutantService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @Autowired
    private StatisticService estadisticService;


    @PostMapping("/mutant")
    public ResponseEntity<?> isMutant(
            @ApiParam(value = "request", required = true,
                    example = "{\"dna\":\"[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\"," +
                            "\"CCCCTA\",\"TCACTG\"]\"}")
            @RequestBody Map<String, String[]> request) {
        Statistic currentStatitic = estadisticService.getEstadistic().get();
        if (!mutantService.isMutant(request.get("dna"))) {
                Integer countHuman = currentStatitic.getCountHumanDna();
            currentStatitic.setCountHumanDna(++countHuman);
            estadisticService.save(currentStatitic);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Integer countMutant = currentStatitic.getCountMutantDna();
        currentStatitic.setCountMutantDna(++countMutant);
        estadisticService.save(currentStatitic);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler
    public ResponseEntity<?> handlerInvalidException(ExceptionValidation exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", exception.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
