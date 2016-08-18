package org.mattshine.katas.romannumerals;

enum RomanSymbol {
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    public final int arabicNumber;

    RomanSymbol(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }
}
