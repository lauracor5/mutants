package utils;


import data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidationsTest {

    Validations validations;

    @BeforeEach
    void setUp() {
        validations = new Validations();
    }

    @Test
    void testValidateCharArray() {
        boolean validate = false;
        String[] dna = Data.createTableDnaMutant();
        for (String row : dna) {
            validate = validations.validateArrayCharacter(row, dna.length);
        }
        assertTrue(validate);
    }
}