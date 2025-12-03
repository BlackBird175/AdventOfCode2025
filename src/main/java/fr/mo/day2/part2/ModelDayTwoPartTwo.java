package fr.mo.day2.part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ModelDayTwoPartTwo {

    private final String filePath = "/home/kandinsky/Documents/CodeExos/AdventOfCode2025/src/main/java/fr/mo/day2" +
            "/part1/instructions.txt";
    private String line;
    private String[] ranges = null;
    private List<Long> invalidIds = new ArrayList<>();

    public ModelDayTwoPartTwo() throws FileNotFoundException {
    }

    public void splitEachRange() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        br.close();
        ranges = line.split(",");
    }

    private boolean isRepeatedPatterns(String s) {
        int numberLength = s.length();
        for (int patternLength = 1; patternLength <= numberLength / 2; patternLength++) {
            if (numberLength % patternLength != 0) continue; // Il passe à la prochaine itération donc ne sors pas de la boucle

            String pattern = s.substring(0, patternLength);
            boolean isValid = true;

            for (int i = patternLength; i < numberLength; i += patternLength) {
                if (!s.startsWith(pattern, i)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return true;
            }
        }
        return false;
    }

    public void findInvalidIds(){
        for (String range : ranges) {
            String[] interval = range.split("-");
            Long lowest = Long.parseLong(interval[0]);
            Long highest = Long.parseLong(interval[1]);

            for (long i = lowest; i <= highest; i++) {
                String indexStr = Long.toString(i);

                if (isRepeatedPatterns(indexStr)) {
                    invalidIds.add(Long.parseLong(indexStr));
                }
            }
        }
    }

    public Long calculateSumOfInvalidIds() throws IOException {
        splitEachRange();
        findInvalidIds();
        return invalidIds.stream().reduce(0L, Long::sum);
    }
}
