package fr.mo.day2.part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelDayTwo {

    private final String filePath = "/home/kandinsky/Documents/CodeExos/AdventOfCode2025/src/main/java/fr/mo/day2" +
            "/part1/instructions.txt";
    private String line;
    private String[] ranges = null;
    private List<Long> invalidIds = new ArrayList<>();

    public ModelDayTwo() throws FileNotFoundException {
    }

    public void splitEachRange() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        br.close();
        ranges = line.split(",");
    }

    public void findInvalidIds(){
        for (String range : ranges) {
            String[] interval = range.split("-");
            String lowest = interval[0];
            String highest = interval[1];

            for (long i = Long.parseLong(lowest); i <= Long.parseLong(highest); i++) {
                String numberStr = Long.toString(i);
                int length = numberStr.length();

                if (length % 2 == 0) {
                    String left = numberStr.substring(0, length / 2);
                    String right = numberStr.substring(length / 2);

                    if (left.equals(right)) {
                        invalidIds.add(i);
                    }
                }
            }
        }
    }

    public Long calculateSumOfInvalidIds() throws IOException {
        splitEachRange();
        findInvalidIds();
        return invalidIds.stream().mapToLong(Long::longValue).sum();
    }
}