package org.mattshine.katas.romannumerals;

import java.util.Arrays;

public enum ArabicToRomanConverter {
    ITERATIVE {
        @Override
        public String convert(Integer arabicNumber) {
            String result = "";

            for (RomanSymbol romanSymbol : RomanSymbol.values()) {
                final int symbolNumber = romanSymbol.arabicNumber;
                while (arabicNumber >= symbolNumber) {
                    result += romanSymbol.toString();
                    arabicNumber -= symbolNumber;
                }

            }
            return result;
        }
    },
    RECURSIVE {
        @Override
        public String convert(Integer arabicNumber) {

            final RomanSymbol symbol = Arrays.stream(RomanSymbol.values()).filter(romanSymbol ->
                    romanSymbol.arabicNumber <= arabicNumber
            ).findFirst().get();

            if (symbol.arabicNumber == arabicNumber) {
                return symbol.toString();
            }

            return symbol.toString() + convert(arabicNumber - symbol.arabicNumber);
        }
    };

    public abstract String convert(Integer arabicNumber);
}
