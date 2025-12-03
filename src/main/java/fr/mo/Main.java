package fr.mo;

import fr.mo.day3.part1.ModelDayThreePartOne;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ModelDayThreePartOne modelDayThreePartOne = new ModelDayThreePartOne();
        modelDayThreePartOne.readInstructions();
        modelDayThreePartOne.getMaxJoltage();
        System.out.println(modelDayThreePartOne.getSumOfMaxJoltage());
    }
}