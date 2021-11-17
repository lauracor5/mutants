package com.co.prueba.mercadoLibre.msmutantsN2.data;

public class Data {

    static int longTable = 6;

    public static String[] createTableDnaMutant() {
        String[] table =
                {"ATGCGG", "CAGTGC", "TTATGT", "AGAAGG", "CCCTTA", "TCACTG"};
        return table;
    }

    public static String[] createTableDnaNoMutant() {
        String[] table =
                {"ATGCTA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        return table;
    }

    public static String[] createTableDnaBad() {
        String[] table =
                {"ATGCTA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTK"};
        return table;
    }

}
