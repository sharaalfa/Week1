package test.java;

import a.sharafutdinov.Manager;
import a.sharafutdinov.Parser;
import a.sharafutdinov.ParserErrorException;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by innopolis on 14.02.17.
 */
class ParserTest {
    private Parser parser;

    private ArrayList<String> test(String input) throws ParserErrorException {
        Parser parser = new Parser(new Scanner(input));
        ArrayList<String> wrd = new ArrayList<String>();
        String value;
        while ((value = parser.getNext()) != null) {
            wrd.add(value);
        }
        System.out.println(wrd);
        return wrd;

    }


    @Test
    public void unpunctTest() throws ParserErrorException {
        assertEquals(Arrays.asList("слово", "сила"), test("слово, сила!"));
        assertEquals(Arrays.asList("москва", "Москва"), test("москва Москва"));


    }

    @Test
    void latinTest() {
        try {
            test("Donald");
            fail("latin character!");
        } catch (ParserErrorException e) {

        }
    }

    @Test
    void digitTest() {
        try {
            test("1234");

        } catch (ParserErrorException e) {

        }
    }
}


