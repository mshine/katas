package org.mattshine.katas.test.romannumerals.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.mattshine.katas.romannumerals.ArabicToRomanConverter;
import org.mattshine.katas.romannumerals.ConverterException;
import org.mattshine.katas.romannumerals.RomanNumerals;

import java.util.Objects;

public class IsRomanMatcher extends TypeSafeDiagnosingMatcher<Integer> {

    private final String numeral;
    private final ArabicToRomanConverter converter;

    private IsRomanMatcher(String numeral, ArabicToRomanConverter converter) {
        this.numeral = numeral;
        this.converter = converter;
    }

    public static Matcher<Integer> isRoman(String romanNumeral, ArabicToRomanConverter converter) {
        return new IsRomanMatcher(romanNumeral, converter);
    }

    public static Matcher<Integer> isRoman(String numeral) {
        return new IsRomanMatcher(numeral, ArabicToRomanConverter.ITERATIVE);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is roman numeral: ")
                .appendValue(numeral);
    }

    @Override
    protected boolean matchesSafely(Integer arabicNumber, Description mismatchDescription) {
        String roman = null;
        try {
            roman = RomanNumerals.convertToRoman(arabicNumber, converter);
        } catch (ConverterException e) {
            throw new RuntimeException(e);
        }
        if (!Objects.equals(roman, numeral)) {
            mismatchDescription.appendText("was roman numeral: ")
                    .appendValue(roman);
            return false;
        }
        return true;
    }
}
