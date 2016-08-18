package org.mattshine.katas.test.romannumerals;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mattshine.katas.romannumerals.ArabicToRomanConverter;
import org.mattshine.katas.romannumerals.RomanNumerals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RomanNumeralsTest {
    private final int arabicNumber;
    private final String romanNumeral;

    public RomanNumeralsTest(int arabicNumber, String romanNumeral) {
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
                }

        );
    }

    @Test
    public void convertArabicNumbersToRomanNumeralsIterativly() {
        assertThat(arabicNumber, isRoman(romanNumeral));
    }

    @Test
    public void convertArabicNumbersToRomanNumeralsRecursively() {
        assertThat(arabicNumber, isRoman(romanNumeral, ArabicToRomanConverter.RECURSIVE));
    }

    private Matcher<Integer> isRoman(String romanNumeral, ArabicToRomanConverter converter) {
        return new IsRomanMatcher(romanNumeral, converter);
    }

    private Matcher<Integer> isRoman(String numeral) {
        return new IsRomanMatcher(numeral, ArabicToRomanConverter.ITERATIVE);
    }

    private static class IsRomanMatcher extends TypeSafeDiagnosingMatcher<Integer> {

        private final String numeral;
        private final ArabicToRomanConverter converter;

        public IsRomanMatcher(String numeral, ArabicToRomanConverter converter) {
            this.numeral = numeral;
            this.converter = converter;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("is roman numeral: ")
                    .appendValue(numeral);
        }

        @Override
        protected boolean matchesSafely(Integer arabicNumber, Description mismatchDescription) {
            String roman = RomanNumerals.convertToRoman(arabicNumber, converter);
            if (!Objects.equals(roman, numeral)) {
                mismatchDescription.appendText("was roman numeral: ")
                        .appendValue(roman);
                return false;
            }
            return true;
        }
    }
}