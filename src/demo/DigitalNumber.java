package demo;

import demo.entity.Digit;

import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigitalNumber {

    public static String resolver(Digit digit) {

        Map<String, Digit> digits = new HashMap<>();
        digits.put("0", new Digit(" _ ", "| |", "|_|"));
        digits.put("1", new Digit("   ", "  |", "  |"));
        digits.put("2", new Digit(" _ ", " _|", "|_ "));
        digits.put("3", new Digit(" _ ", " _|", " _|"));
        digits.put("4", new Digit("   ", "|_|", "  |"));
        digits.put("5", new Digit(" _ ", "|_ ", " _|"));
        digits.put("6", new Digit(" _ ", "  |", "  |"));
        digits.put("7", new Digit(" _ ", "  |", "  |"));
        digits.put("8", new Digit(" _ ", "|_|", "|_|"));
        digits.put("9", new Digit(" _ ", "|_|", " _|"));

        return digits.entrySet()
                .stream()
                .filter(d -> d.getValue().eq(digit))
                .map(Map.Entry::getKey)
                .findFirst().orElse("");
    }



    public static void main(String[] args) throws IOException {
        File file = new File("src/demo/resources/digits.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String lineFile;
        List<String> list = new ArrayList<>();

        while ((lineFile = br.readLine()) != null) {
            while (lineFile.length() < 30) {
                lineFile += " ";
            }
            list.add(lineFile);
        }
        int fileLineNumber;
        int lineRowFile;
        StringBuilder result = new StringBuilder();
        for (fileLineNumber = 0; fileLineNumber < 44; fileLineNumber += 4) {
            lineRowFile = 0;
            while (lineRowFile < 29) {

                String row1 = (list.get(fileLineNumber)).substring(lineRowFile, 3 + lineRowFile);
                String row2 = (list.get(1 + fileLineNumber)).substring(lineRowFile, 3 + lineRowFile);
                String row3 = (list.get(2 + fileLineNumber)).substring(lineRowFile, 3 + lineRowFile);

                Digit toResolve = new Digit(row1, row2, row3);
                result.append(resolver(toResolve));
                lineRowFile += 3;
            }
            result.append('\n');

        }
        System.out.println(result);
        try (PrintStream out = new PrintStream(
                new FileOutputStream("src/demo/resources/outputs.txt")))
        {
            out.print(result);
        }

    }


}




