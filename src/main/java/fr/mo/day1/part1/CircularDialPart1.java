package fr.mo.day1.part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CircularDialPart1 {
    private final String filePath = "/home/kandinsky/Documents/CodeExos/AdventOfCode2025/src/main/resources/instructions.txt";
    private BufferedReader br = new BufferedReader(new FileReader(filePath));
    private String line;
    private int countZeros = 0;

    public CircularDialPart1() throws FileNotFoundException {
    }

    public void readInstructions() {
        int start = 50;
        try {
            while((line = br.readLine()) != null){
                String letter = line.replaceAll("[0-9]", "");
                String digits = line.replaceAll("[A-Za-z]", "");

                if (letter.equals("L")){
                    start = (start - Integer.parseInt(digits)) % 100;
                }
                else if (letter.equals("R")){
                    start = (start + Integer.parseInt(digits)) % 100;
                }

                if (start == 0){
                    countZeros++;
                }
                System.out.println(countZeros);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
