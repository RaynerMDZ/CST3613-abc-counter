package edu.citytech.cst.s23253396.abccounter.services;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class AbcCounterServiceTest {

    private final AbcCounterService counterService = new AbcCounterService();

    @Test
    void countABC() {
        List<Character> expectedList = this.counterService.countABC();
        String uppercase = "abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT);
        String lowercase = "abcdefghijklmnopqrstuvwxyz".toLowerCase(Locale.ROOT);
        String alphabet = uppercase + lowercase;
        List<Character> actualList = alphabet.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        assertEquals(expectedList, actualList);
    }

    @Test
    void count123() {
        List<Integer> expectedList = IntStream.range(1, 501).boxed().collect(Collectors.toList());
        List<Integer> actualList = this.counterService.count123();
        assertEquals(expectedList, actualList);
    }

    @Test
    void isVowel() {
        String vowel = "a";
        boolean isVowel = this.counterService.isVowel(vowel);
        assertTrue(isVowel);
    }

    @Test
    void isConstant() {
        String consonant = "r";
        boolean isConsonant = this.counterService.isConstant(consonant);
        assertTrue(isConsonant);
    }

    @Test
    void isEven() {
        int even = 100;
        boolean isEven = this.counterService.isEven(even);
        assertTrue(isEven);
    }

    @Test
    void isOdd() {
        int odd = 101;
        boolean isOdd = this.counterService.isOdd(odd);
        assertTrue(isOdd);
    }
}