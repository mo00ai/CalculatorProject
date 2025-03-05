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


    //인자값이 오퍼레이터타입 필드에 포함되어있는지 확인하는 메서드
    public static boolean contains(char value) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.getValue() == value) {
                return true;
            }
        }
        return false;
    }










}
