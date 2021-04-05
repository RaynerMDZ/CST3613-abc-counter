package edu.citytech.cst.s23253396.abccounter.services;

import java.util.List;

public interface AbcCounterService {

    List<Character> countABC();
    List<Character> countCBA();
    List<String> countAaBbCc();
    List<Integer> count123();
    List<Integer> count321();
    List<Integer> count369();
    boolean isVowel(String string);
    boolean isVowelAaBbCc(String string);
    boolean isConsonant(String string);
    boolean isConsonantAaBbCc(String string);
    boolean isEven(int integer);
    boolean isOdd(int integer);
    boolean isDivisibleBy6(int integer);
    boolean contains7(int integer);
}
