package no.itfakultetet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path fil = Path.of("test.txt");

        try (BufferedWriter ut = Files.newBufferedWriter(fil)) {
            ut.write("Dette er en tekst");
            ut.newLine();
            ut.append("Og her er en linje til");
            ut.newLine();
            ut.append("ÆØÅæøå");
            ut.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            Files.lines(fil).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (BufferedReader in = Files.newBufferedReader(fil);) {
            List<String> linjer = in.lines().toList();
            List<String> linjer2 = new ArrayList<>(linjer);
            linjer2.add("Dette er en linje til");

            linjer2.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
