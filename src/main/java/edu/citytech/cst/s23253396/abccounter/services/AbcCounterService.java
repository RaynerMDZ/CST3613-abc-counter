package edu.citytech.cst.s23253396.abccounter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class AbcCounterService {

    private final static Pattern alphabet = Pattern.compile("^[a-zA-Z]*$");

    public List<Character> countABC() {
        List<Character> abc = new ArrayList<>();

        for (Character letter = 'A'; letter <= 'z'; letter++) {
            if (alphabet.matcher(String.valueOf(letter)).find()) {
                abc.add(letter);
            }
        }
        return abc;
    }

    public  List<Integer> count123() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            integers.add(i);
        }
        return integers;
    }

    public boolean isVowel(String string) {
        // Java 8 Functional Programming
        return Stream.of("a", "e", "i", "o", "u")
                .anyMatch(string::equalsIgnoreCase);
    }
}
