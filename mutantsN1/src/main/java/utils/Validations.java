package utils;

import java.util.Scanner;

public class Validations {
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

    private boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


