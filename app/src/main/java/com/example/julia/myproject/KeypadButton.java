package com.example.julia.myproject;


public enum KeypadButton {
    DUMMY("",KeypadButtonCategory.DUMMY),
    BACKSPACE("<-", KeypadButtonCategory.CLEAR),
    CALCULATE("=", KeypadButtonCategory.RESULT),
    C("C", KeypadButtonCategory.CLEAR),
    ZERO("0", KeypadButtonCategory.NUMBER),
    ONE("1", KeypadButtonCategory.NUMBER),
    TWO("2", KeypadButtonCategory.NUMBER),
    THREE("3", KeypadButtonCategory.NUMBER),
    FOUR("4", KeypadButtonCategory.NUMBER),
    FIVE("5", KeypadButtonCategory.NUMBER),
    SIX("6", KeypadButtonCategory.NUMBER),
    SEVEN("7", KeypadButtonCategory.NUMBER),
    EIGHT("8", KeypadButtonCategory.NUMBER),
    NINE("9", KeypadButtonCategory.NUMBER),
    PLUS("+", KeypadButtonCategory.OPERATOR),
    MINUS("-", KeypadButtonCategory.OPERATOR),
    MULTIPLY("*", KeypadButtonCategory.OPERATOR),
    DIV("/", KeypadButtonCategory.OPERATOR),
    Point(".", KeypadButtonCategory.OTHER),
    SQRT("√", KeypadButtonCategory.OTHER),
    BRACKETOPEN("(", KeypadButtonCategory.OTHER),
    BRACKETCLOSE(")", KeypadButtonCategory.OTHER),
    SIN("sin(", KeypadButtonCategory.TRIGONOMETRY),
    COS("cos(", KeypadButtonCategory.TRIGONOMETRY),
    TAN("tan(", KeypadButtonCategory.TRIGONOMETRY),
    CTG("ctg(", KeypadButtonCategory.TRIGONOMETRY),
    X("x",KeypadButtonCategory.FORFUNCTION),
    Y("y",KeypadButtonCategory.FORFUNCTION),
    Z("z",KeypadButtonCategory.FORFUNCTION),
    POW("^2",KeypadButtonCategory.OTHER),
    DIV1onX("1/x",KeypadButtonCategory.OTHER);


    CharSequence mText;
    KeypadButtonCategory mCategory;


    KeypadButton(CharSequence text, KeypadButtonCategory category) {
        mText = text;
        mCategory = category;
    }

    public CharSequence getText() {
        return mText;
    }
}
