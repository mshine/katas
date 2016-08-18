package org.mattshine.katas.test.romannumerals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mattshine.katas.romannumerals.ConverterException;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertThat;
import static org.mattshine.katas.romannumerals.ArabicToRomanConverter.RECURSIVE;
import static org.mattshine.katas.romannumerals.RomanNumerals.convertToRoman;
import static org.mattshine.katas.test.romannumerals.matchers.IsRomanMatcher.isRoman;

public class RomanNumeralsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void tellsTheUserTheValidRange() throws Exception {
        thrown.expect(ConverterException.class);
        thrown.expectMessage("Only arabic numbers in the range [1, 4000] are valid.");
        convertToRoman(0);
    }

    @Test
    public void throwsExceptionForZeroIteratively() throws Exception {
        thrown.expect(ConverterException.class);
        thrown.expectMessage("Cannot convert 0 to a Roman Numeral");
        convertToRoman(0);
    }

    @Test
    public void throwsExceptionForZeroRecursively() throws Exception {
        thrown.expect(ConverterException.class);
        thrown.expectMessage("Cannot convert 0 to a Roman Numeral");
        convertToRoman(0, RECURSIVE);
    }

    @Test
    public void throwsExceptionForNegativeNumberIteratively() throws Exception {
        thrown.expect(ConverterException.class);
        thrown.expectMessage("Cannot convert -5 to a Roman Numeral");
        convertToRoman(-5);
    }

    @Test
    public void throwsExceptionForNegativeNumberRecursively() throws Exception {
        thrown.expect(ConverterException.class);
        thrown.expectMessage("Cannot convert -5 to a Roman Numeral");
        convertToRoman(-5, RECURSIVE);
    }

    @Test
    public void throwsExceptionForNumberOver3999Iteratively() throws Exception {
        thrown.expect(ConverterException.class);
        thrown.expectMessage("Cannot convert 4000 to a Roman Numeral");
        convertToRoman(4000);
    }

    @Test
    public void throwsExceptionForNumberOver3999Recursively() throws Exception {
        thrown.expect(ConverterException.class);
        thrown.expectMessage("Cannot convert 4000 to a Roman Numeral");
        convertToRoman(4000, RECURSIVE);
    }

    @RunWith(Parameterized.class)
    public static class RomanNumeralsParametrizedTest {
        private final int arabicNumber;
        private final String romanNumeral;

        public RomanNumeralsParametrizedTest(int arabicNumber, String romanNumeral) {
            this.arabicNumber = arabicNumber;
            this.romanNumeral = romanNumeral;
        }


        @Parameterized.Parameters(name = "toRoman({0}) = \"{1}\"")
        public static Collection<Object[]> testCases() {
            return Arrays.asList(new Object[][]{
                            {1, "I"},
                            {2, "II"},
                            {3, "III"},
                            {5, "V"},
                            {6, "VI"},
                            {7, "VII"},
                            {8, "VIII"},
                            {10, "X"},
                            {11, "XI"},
                            {12, "XII"},
                            {13, "XIII"},
                            {15, "XV"},
                            {20, "XX"},
                            {4, "IV"},
                            {9, "IX"},
                            {14, "XIV"},
                            {19, "XIX"},
                            {40, "XL"},
                            {50, "L"},
                            {90, "XC"},
                            {100, "C"},
                            {400, "CD"},
                            {500, "D"},
                            {900, "CM"},
                            {1000, "M"},
                            {1999, "MCMXCIX"},
                            {1948, "MCMXLVIII"},
                    }

            );
        }

        @Test
        public void convertArabicNumbersToRomanNumeralsIteratively() {
            assertThat(arabicNumber, isRoman(romanNumeral));
        }

        @Test
        public void convertArabicNumbersToRomanNumeralsRecursively() {
            assertThat(arabicNumber, isRoman(romanNumeral, RECURSIVE));
        }

    }

}

