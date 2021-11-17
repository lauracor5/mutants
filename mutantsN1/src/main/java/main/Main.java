package main;


import service.MutantService;
import service.MutantServiceimpl;
import utils.Validations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Validations validations = new Validations();
        MutantService mutant = new MutantServiceimpl();
        String dna[] =validations.insertDna();
        mutant.isMutant(dna);
        System.out.println(mutant.isMutant(dna));
    }

}