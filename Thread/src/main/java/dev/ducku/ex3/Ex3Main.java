package dev.ducku.ex3;

import java.util.ArrayList;
import java.util.List;

public class Ex3Main {

    public static List<Integer> bucket = new ArrayList<>();

    public static void main(String[] args) {

        PrintOddNumber odd = new PrintOddNumber("Odd");
        PrintEvenNumber even = new PrintEvenNumber("Even");
        PrintOddNumber odd2 = new PrintOddNumber("Odd2");
        PrintEvenNumber even2 = new PrintEvenNumber("Even2");
        odd.start();
        even.start();


    }



}
