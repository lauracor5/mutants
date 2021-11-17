package com.co.prueba.mercadoLibre.msmutantsN2.controller;

import com.co.prueba.mercadoLibre.msmutantsN2.exceptions.ExceptionValidation;
import com.co.prueba.mercadoLibre.msmutantsN2.service.MutantService;
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

    @PostMapping("/mutant")
    public ResponseEntity<?>isMutant(
            @ApiParam(value = "is Mutant", required = true,
            example = "{\"dna\":\"[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]\"}")
            @RequestBody Map<String, String[]> request)  {
        if(!mutantService.isMutant(request.get("dna"))){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler
    public ResponseEntity<?> handlerInvalidException(ExceptionValidation exception){
        Map<String, Object>response= new HashMap<>();
        response.put("message", exception.getMessage());
        return ResponseEntity.badRequest().body(response);
    }



}
