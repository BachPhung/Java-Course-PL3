package readFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class LineWrap {
    public static void main(String[] args) throws IOException {
        BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Give input filename: ");
        final String inputFilename = user.readLine();
        if ("quit".equalsIgnoreCase(inputFilename)) {
            return;
        }
        int inputLines = 0;
        int outputLines = 0;
        System.out.println("Give line limit: ");
        final int lineLimit = Integer.parseInt(user.readLine());
        System.out.println("Give output filename");
        final String outputFilename = user.readLine();
        try (var input = new BufferedReader(new FileReader(inputFilename));
                var output = new PrintStream(outputFilename)) {
            String line = null;
            int lineLen = 0;
            while ((line = input.readLine()) != null) {
                inputLines += 1;
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (lineLen > 0 && lineLen + 1 + word.length() > lineLimit) {
                        outputLines += 1;
                        lineLen = 0;
                        output.println();
                    }
                    if (lineLen > 0) {
                        output.print(" ");
                        lineLen+=1;
                    }
                    output.print(word);
                    lineLen+= word.length();
                }
            }
        }
        System.out.printf("The input file %s had %d lines.%n", inputFilename, inputLines);
        System.out.printf("The output file %s had %d lines", outputFilename, outputLines);
    }
}