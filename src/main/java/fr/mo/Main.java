package fr.mo;

import fr.mo.day2.part1.ModelDayTwo;
import fr.mo.day2.part2.ModelDayTwoPartTwo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ModelDayTwoPartTwo model = new ModelDayTwoPartTwo();
        System.out.println(model.calculateSumOfInvalidIds());
    }
}