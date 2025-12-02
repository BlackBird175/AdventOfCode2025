package fr.mo;

import fr.mo.day2.part1.ModelDayTwo;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ModelDayTwo model = new ModelDayTwo();
        model.splitEachRange();
        model.findInvalidIds();
        System.out.println(model.calculateSumOfInvalidIds());
    }
}