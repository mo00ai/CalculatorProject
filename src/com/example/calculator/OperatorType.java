package com.example.calculator;

public enum OperatorType {
    SUM('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private char value;

    OperatorType(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static boolean contains(char value) {

        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.getValue() == value) {
                return true;
            }
        }

        return false;
    }










}
