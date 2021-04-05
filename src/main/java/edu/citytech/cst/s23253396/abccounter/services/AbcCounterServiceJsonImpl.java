package edu.citytech.cst.s23253396.abccounter.services;

import com.jbbwebsolutions.http.utility.JSONGet;

import java.util.Arrays;
import java.util.List;

public class AbcCounterServiceJsonImpl implements AbcCounterService {

    private final String ABC_SERVICE_URL = "http://localhost:8080/api/v1";
    private final String MODE_ABC = this.ABC_SERVICE_URL + "/mode/abc";
    private final String MODE_CBA = this.ABC_SERVICE_URL + "/mode/cba";
    private final String MODE_AaBbCc = this.ABC_SERVICE_URL + "/mode/AaBbCc";
    private final String MODE_123 = this.ABC_SERVICE_URL + "/mode/123";
    private final String MODE_321 = this.ABC_SERVICE_URL + "/mode/321";
    private final String MODE_369 = this.ABC_SERVICE_URL + "/mode/369";
    private final String IS_VOWEL = this.ABC_SERVICE_URL + "/isVowel/";
    private final String IS_VOWEL_AaBbCc = this.ABC_SERVICE_URL + "/isVowelAaBbCc/";
    private final String IS_CONSONANT = this.ABC_SERVICE_URL + "/isConsonant/";
    private final String IS_CONSONANT_AaBbCc = this.ABC_SERVICE_URL + "/isConsonantAaBbCc/";
    private final String IS_EVEN = this.ABC_SERVICE_URL + "/isEven/";
    private final String IS_ODD = this.ABC_SERVICE_URL + "/isOdd/";
    private final String IS_DIVISIBLE_BY_6 = this.ABC_SERVICE_URL + "/isDivisibleBy6/";
    private final String CONTAINS_7 = this.ABC_SERVICE_URL + "/contains7/";

    @Override
    public List<Character> countABC() {
        return Arrays.asList(JSONGet.submitGet(this.MODE_ABC, Character[].class));
    }

    @Override
    public List<Character> countCBA() {
        return Arrays.asList(JSONGet.submitGet(this.MODE_CBA, Character[].class));
    }

    @Override
    public List<String> countAaBbCc() {
        return Arrays.asList(JSONGet.submitGet(this.MODE_AaBbCc, String[].class));
    }

    @Override
    public List<Integer> count123() {
        return Arrays.asList(JSONGet.submitGet(this.MODE_123, Integer[].class));
    }

    @Override
    public List<Integer> count321() {
        return Arrays.asList(JSONGet.submitGet(this.MODE_321, Integer[].class));
    }

    @Override
    public List<Integer> count369() {
        return Arrays.asList(JSONGet.submitGet(this.MODE_369, Integer[].class));
    }

    @Override
    public boolean isVowel(String string) {
        return JSONGet.submitGet(this.IS_VOWEL + string, boolean.class);
    }

    @Override
    public boolean isVowelAaBbCc(String string) {
        return JSONGet.submitGet(this.IS_VOWEL_AaBbCc + string, boolean.class);
    }

    @Override
    public boolean isConsonant(String string) {
        return JSONGet.submitGet(this.IS_CONSONANT + string, boolean.class);
    }

    @Override
    public boolean isConsonantAaBbCc(String string) {
        return JSONGet.submitGet(this.IS_CONSONANT_AaBbCc + string, boolean.class);
    }

    @Override
    public boolean isEven(int integer) {
        return JSONGet.submitGet(this.IS_EVEN + integer, boolean.class);
    }

    @Override
    public boolean isOdd(int integer) {
        return JSONGet.submitGet(this.IS_ODD + integer, boolean.class);
    }

    @Override
    public boolean isDivisibleBy6(int integer) {
        return JSONGet.submitGet(this.IS_DIVISIBLE_BY_6 + integer, boolean.class);
    }

    @Override
    public boolean contains7(int integer) {
        return JSONGet.submitGet(this.CONTAINS_7 + integer, boolean.class);
    }
}
