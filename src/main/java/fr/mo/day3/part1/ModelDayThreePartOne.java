package fr.mo.day3.part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelDayThreePartOne {

    private final String filePath = "/home/kandinsky/Documents/CodeExos/AdventOfCode2025/src/main/java/fr/mo/day3" +
            "/part1/instructions.txt";
    private BufferedReader br = new BufferedReader(new FileReader(filePath));
    private String line;
    private List<String> lines = new ArrayList<>();
    private List<Integer> joltatges = new ArrayList<>();

    public ModelDayThreePartOne() throws FileNotFoundException {}

    public void readInstructions() throws FileNotFoundException {
        try {
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getMaxJoltage(){
        for(String line : lines){
            List<Integer> digits = new ArrayList<>();
            for(int i = 0; i < line.length(); i++){
                digits.add(line.charAt(i) - '0');
            }

            int max = -1;

            for(int i = 0; i < digits.size(); i++){
                int first =  digits.get(i);
                for(int j = i + 1; j < digits.size(); j++){
                    int second = digits.get(j);
                    int value = first * 10 + second;

                    if(value > max){
                        max = value;
                    }
                }
            }
            joltatges.add(max);
        }
    }

    public int getSumOfMaxJoltage(){
        return joltatges.stream().mapToInt(Integer::intValue).sum();
    }

    public List<String> getLines() {
        return lines;
    }
}
