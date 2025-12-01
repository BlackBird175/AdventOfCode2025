package fr.mo;

import fr.mo.day1.CircularDial;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        CircularDial circularDial = new CircularDial();
        circularDial.readInstructions();
    }
}