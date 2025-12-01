package fr.mo.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CircularDial {

    private final String filePath = "/home/kandinsky/Documents/CodeExos/AdventOfCode2025/src/main/resources/instructions.txt";
    private BufferedReader br = new BufferedReader(new FileReader(filePath));
    private String line;
    private int countZeros = 0;

    public void readInstructions() {
        int start = 50;
        try {
            while((line = br.readLine()) != null){

                String letter = line.replaceAll("[0-9]", "");
                String digits = line.replaceAll("[A-Za-z]", "");

                int value = Integer.parseInt(digits);

                if (letter.equals("L")) {
                    for (int i = 0; i < value; i++) {
                        start = (start - 1 + 100) % 100;
                        if (start == 0) countZeros++;
                    }
                }
                else if (letter.equals("R")) {
                    for (int i = 0; i < value; i++) {
                        start = (start + 1) % 100;
                        if (start == 0) countZeros++;
                    }
                }
            }

            br.close();
            System.out.println(countZeros);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public CircularDial() throws FileNotFoundException {
    }

}
