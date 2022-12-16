package lab4;

import java.io.*;
import java.util.*;

class CSVClass {

    private static final String SYMBOL_CSV = ";";
    private Map<String, Integer> mapWords = new HashMap<>();
    private List<Map.Entry<String, Integer>> listWords;
    private int count;

	CSVClass(String inFileName, String outFileName) throws IOException {

        if (inFileName == null) {
            System.out.println("\n\tInvalid input file name!");
            return;
        } else {
            readFileWords(inFileName);
        }

        if (outFileName != null) {
            File file = new File(outFileName);
            try (PrintWriter writer = new PrintWriter(file.getAbsoluteFile())) {
                writeFileWords(listWords, count, writer);
                System.out.println("\n\tcsv file done!");
            }
        }
        else {
            showWords(listWords, count);
        }
    }

    private void readFileWords(String inFileName) throws IOException {

        try (Reader reader = new InputStreamReader(new FileInputStream(inFileName))) {
            StringBuilder builder = new StringBuilder();
            int currentSymbol;

            while ((currentSymbol = reader.read()) != -1) {
                char charSymbol = (char) currentSymbol;

                if (Character.isLetterOrDigit(charSymbol) || charSymbol == '\'') {
                    builder.append(charSymbol);
                } else if (builder.length() > 0) {
                    addMap(mapWords, builder.toString());
                    count++;
                    builder.delete(0, builder.length());
                }
            }

            if (builder.length() > 0) {
                addMap(mapWords, builder.toString());
                count++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("\n\tCan't find input file!");
        }

        listWords = sortedMap(mapWords);
    }

    private void addMap(Map<String, Integer> map, String word) {
        int pass = 1;
        Integer curPass = map.get(word);
        if (curPass != null) {
            pass += curPass;
        }
        map.put(word, pass);
    }

    private List<Map.Entry<String, Integer>> sortedMap(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            int rs = o2.getValue().compareTo(o1.getValue());
            if (rs == 0) {
                rs = o1.getKey().compareTo(o2.getKey());
            }
            return rs;
        });
        return list;
    }

    private void writeFileWords(List<Map.Entry<String, Integer>> list, int numbersOfLines, PrintWriter writer) {

        writer.printf("%s" + SYMBOL_CSV + "%s" + SYMBOL_CSV + "%s%n", "Words", "Amount", "Percentage%");
        for (Map.Entry<String, Integer> aList : list) {
            writer.printf("%s" + SYMBOL_CSV + "%s" + SYMBOL_CSV + "%.3f%n", aList.getKey(), aList.getValue(), (100.0f * aList.getValue() / numbersOfLines));
        }
        writer.printf("%n%s" + SYMBOL_CSV + "%d", "Total:", numbersOfLines);
    }

    private void showWords(List<Map.Entry<String, Integer>> list, int numbersOfLines) {

        System.out.printf("\t%-20s%-15s%s%n", "Words", "Amount", "Percentage%");
        for (Map.Entry<String, Integer> aList : list) {
            System.out.printf("\t\b%-22s%-14s%.3f%n", aList.getKey(), aList.getValue(), (100.0f * aList.getValue() / numbersOfLines));
        }
        System.out.printf("\n\tTotal:" + numbersOfLines);
    }
}