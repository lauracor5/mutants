package com.co.prueba.mercadoLibre.msmutantsN2.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionValidation extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String message;

    public ExceptionValidation(String message) {
        this.message= message;
    }
}
