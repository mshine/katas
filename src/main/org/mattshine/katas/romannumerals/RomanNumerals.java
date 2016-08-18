package org.mattshine.katas.romannumerals;

public class RomanNumerals {

    public static String convertToRoman(int arabicNumber) throws ConverterException {
        return convertToRoman(arabicNumber, ArabicToRomanConverter.ITERATIVE);
    }

    public static String convertToRoman(Integer arabicNumber, ArabicToRomanConverter converter) throws ConverterException {
        if (withinValidRange(arabicNumber))
            throw new ConverterException(
                    "Cannot convert " + arabicNumber + " to a Roman Numeral." +
                            " Only arabic numbers in the range [1, 4000] are valid."
            );
        return converter.convert(arabicNumber);
    }

    private static boolean withinValidRange(Integer arabicNumber) {
        return arabicNumber <= 0 || arabicNumber > 3999;
    }
}