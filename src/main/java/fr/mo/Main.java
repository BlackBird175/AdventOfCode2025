package fr.mo;

import fr.mo.day1.part2.CircularDialPart2;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        CircularDialPart2 circularDial = new CircularDialPart2();
        circularDial.readInstructions();
    }
}