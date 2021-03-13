package edu.citytech.cst.s23253396.abccounter.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AbcCounterService {

    private final static Pattern alphabet = Pattern.compile("^[a-zA-Z]*$");

    /**
     * This method returns a list of characters representing each letter of the alphabet
     * From A to Z both uppercase and lowercase.
     * @return List<Characters>
     */
    public List<Character> countABC() {
        List<Character> abc = new ArrayList<>();

        for (Character letter = 'A'; letter <= 'z'; letter++) {
            if (alphabet.matcher(String.valueOf(letter)).find()) {
                abc.add(letter);
            }
        }
        return abc;
    }

    /**
     * This method returns a list of integers from n to m.
     * @return List<Integers>
     */
    public  List<Integer> count123() {
        return IntStream.range(1, 501).boxed().collect(Collectors.toList());
    }

    /**
     *
     * @return List<Integer>
     */
    public List<Integer> count321() {
        List<Integer> reversedList = new ArrayList<>(this.count123());
        Collections.reverse(reversedList);
        return reversedList;
    }

    /**
     *  You can use this same function to check for consonants. Just add ! in the controller to check whether a
     *  letter is a vowel or not. e.g. if (!isVowel) {}
     * @param string which is a letter from the gui.
     * @return boolean.
     */
    public boolean isVowel(String string) {
        // Java 8 Functional Programming
        return Stream.of("a", "e", "i", "o", "u")
                .anyMatch(string::equalsIgnoreCase);
    }

    /**
     *
     * @param string which is a letter from the gui.
     * @return boolean.
     */
    public boolean isConstant(String string) {
        return !isVowel(string);
    }

    /**
     *
     * @param integer as a number from the gui.
     * @return boolean.
     */
    public boolean isEven(int integer) {
        return integer % 2 == 0;
    }

    /**
     *
     * @param integer as a number from the gui.
     * @return boolean.
     */
    public boolean isOdd(int integer) {
        return !isEven(integer);
    }

    /**
     *
     * @param integer as a number from the gui.
     * @return boolean.
     */
    public boolean isDivisibleBy6(int integer) {
        return integer % 6 == 0;
    }
}
