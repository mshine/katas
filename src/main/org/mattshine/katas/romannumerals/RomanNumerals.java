package org.mattshine.katas.romannumerals;

public class RomanNumerals {

    public static String convertToRoman(int arabicNumber) {
        return convertToRoman(arabicNumber, ArabicToRomanConverter.ITERATIVE);
    }

    public static String convertToRoman(Integer arabicNumber, ArabicToRomanConverter converter) {
        return converter.convert(arabicNumber);
    }

}
