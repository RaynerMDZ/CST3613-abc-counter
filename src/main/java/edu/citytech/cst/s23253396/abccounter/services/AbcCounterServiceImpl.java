package edu.citytech.cst.s23253396.abccounter.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AbcCounterServiceImpl implements AbcCounterService {

    private final static Pattern alphabet = Pattern.compile("^[a-zA-Z]*$");

    /**
     * This method returns a list of characters representing each letter of the alphabet
     * From A to Z both uppercase and lowercase.
     * @return List<Characters>
     */
    @Override
    public List<Character> countABC() {
        List<Character> abc = new ArrayList<>();

        for (Character letter = 'A'; letter <= 'z'; letter++) {
            if (alphabet.matcher(String.valueOf(letter)).find()) {
                abc.add(letter);
            }
        }
        return abc;
    }

    @Override
    public List<Character> countCBA() {
        List<Character> reversedAlphabet = new ArrayList<>(this.countABC());
        Collections.reverse(reversedAlphabet);
        return reversedAlphabet;
    }

    @Override
    public List<String> countAaBbCc() {
        List<String> AaBbCc = new ArrayList<>();

        for (char letter = 'A'; letter <= 'Z'; letter++) {
            AaBbCc.add(letter + "-" + String.valueOf(letter).toLowerCase(Locale.ROOT));
        }
        return AaBbCc;
    }

    /**
     * This method returns a list of integers from n to m.
     * @return List<Integers>
     */
    @Override
    public  List<Integer> count123() {
        return IntStream.range(1, 1501).boxed().collect(Collectors.toList());
    }

    /**
     *
     * @return List<Integer>
     */
    @Override
    public List<Integer> count321() {
        List<Integer> reversedList = new ArrayList<>(this.count123());
        Collections.reverse(reversedList);
        return reversedList;
    }

    @Override
    public List<Integer> count369() {
        return this.count123()
                .stream()
                .filter(integer -> integer % 3 == 0)
                .collect(Collectors.toList());
    }

    /**
     *  You can use this same function to check for consonants. Just add ! in the controller to check whether a
     *  letter is a vowel or not. e.g. if (!isVowel) {}
     * @param string which is a letter from the gui.
     * @return boolean.
     */
    @Override
    public boolean isVowel(String string) {
        // Java 8 Functional Programming
        return Stream.of("a", "e", "i", "o", "u")
                .anyMatch(string::equalsIgnoreCase);
    }

    @Override
    public boolean isVowelAaBbCc(String string) {
        return Stream.of("A-a", "E-e", "I-i", "O-o", "U-u")
                .anyMatch(string::equalsIgnoreCase);
    }

    /**
     *
     * @param string which is a letter from the gui.
     * @return boolean.
     */
    @Override
    public boolean isConsonant(String string) {
        return !isVowel(string);
    }

    @Override
    public boolean isConsonantAaBbCc(String string) {
        return !isVowelAaBbCc(string);
    }

    /**
     *
     * @param integer as a number from the gui.
     * @return boolean.
     */
    @Override
    public boolean isEven(int integer) {
        return integer % 2 == 0;
    }

    /**
     *
     * @param integer as a number from the gui.
     * @return boolean.
     */
    @Override
    public boolean isOdd(int integer) {
        return !isEven(integer);
    }

    /**
     *
     * @param integer as a number from the gui.
     * @return boolean.
     */
    @Override
    public boolean isDivisibleBy6(int integer) {
        return integer % 6 == 0;
    }

    @Override
    public boolean contains7(int integer) {
        return String.valueOf(integer).contains("7");
    }
}
