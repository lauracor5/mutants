package com.co.prueba.mercadoLibre.msmutantsN3.utils;
import com.co.prueba.mercadoLibre.msmutantsN3.exceptions.ExceptionValidation;

public class Validate {

    public  static boolean insertDna(String[]dna) {
        boolean validate = true;
        for (String dnaRow: dna) {
           validate = validateArrayCharacter(dnaRow, dna.length);
        }
        return validate;
    }

    public static boolean validateArrayCharacter(String row, int columns){
        row = row.toUpperCase();
        boolean validate = true;
        String[] validateArray = new String[1];
        validate = row.length() == 0 || row.length() != columns ? false : true;
        if(row.length()==0 || row.length()!=columns){
            validate = false;
            throw new ExceptionValidation("number of characters to enter per row " + columns);
        }

        validateArray = row.split("");
        for (int i = 0; i < row.length(); i++) {
            if (!("A".equals(validateArray[i]) ||
                    "T".equals(validateArray[i]) ||
                    "C".equals(validateArray[i]) ||
                    "G".equals(validateArray[i]))) {
                validate = false;
                throw new ExceptionValidation("Allowed values(A, T, C, G, C)");
            }
        }
        return validate;
    }

}
