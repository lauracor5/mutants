package utils;

import java.util.Scanner;

/**
 * @author: Laura Córdoba
 * @version 1
 * Clase encargada de validar la entrada de los datos del arreglo Strin[] dna
 *
 */
public class Validations {

    /**
     * Se le indica al usuario que ingrese los valores del dna para cada fila
     * @return arreglo de dna validado
     */
    public String[] insertDna() {
        Scanner sc = new Scanner(System.in);
        int longTable = validateLongTable();
        String[] dnaArray = new String[longTable];

        for (int indice = 0; indice < dnaArray.length; indice++) {
            System.out.println("Enter the row values " + indice + " Allowed values (A, T, C, G, C) ");
            if (sc.hasNextLine()) {
                dnaArray[indice] = sc.nextLine();
            }

            if (!(validateArrayCharacter(dnaArray[indice], longTable))) {
                System.out.println("Allowed values(A, T, C, G, C)  -  " +
                        "number of items to enter  " + longTable +
                        " enter the values of the row again " + indice);
                indice--;
            }
        }
        return dnaArray;
    }

    /**
     * Valida que solo se inserten caracteres permitidos "A, T, C, G, C"
     * @param row fila del arreglo
     * @param columns tamaño del arreglo
     * @return false si los valores ingresados en la fila no cumplen con la longitud del tamaño de arreglo
     * o si encuentra un caracter no permitido
     */
    public boolean validateArrayCharacter(String row, int columns) {
        row = row.toUpperCase();
        boolean validate = true;
        String[] validateArray = new String[1];
        validate = row.length() == 0 || row.length() != columns ? false : true;
        validateArray = row.split("");
        for (int i = 0; i < row.length(); i++) {
            if (!("A".equals(validateArray[i]) ||
                    "T".equals(validateArray[i]) ||
                    "C".equals(validateArray[i]) ||
                    "G".equals(validateArray[i]))) {
                validate = false;
                break;
            }
        }
        return validate;
    }

    /**
     * Se le pide al usuario que ingrese el tamaño del arreglo, debe ser un valor numerico, si es diferente
     * se le pedira de nuevo al usuario un valor permitid
     * @return el tamaño del arreglo del dna
     */
    private int validateLongTable() {
        Scanner sc = new Scanner(System.in);
        String valueLongTable;
        System.out.println("Enter the length of the table");
        valueLongTable = sc.nextLine();
        while (!isNumeric(valueLongTable)) {
            System.out.println("Enter a numeric value");
            sc = new Scanner(System.in);
            if (sc.hasNextLine()) {
                valueLongTable = sc.nextLine();
            }
            isNumeric(valueLongTable);
        }

        return Integer.parseInt(valueLongTable);
    }

    /**
     * @param value valor del tamaño de arreglo ingresado por el usuario
     * @return false si el valor ingresado por consola no es numerico
     */
    private boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


