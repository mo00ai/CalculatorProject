package com.example.calculator;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ArithmeticCalculator {

    //필드
    Queue<Number> resultList = new LinkedList<Number>();

    //생성자


    //게터 세터
    public Queue<Number> getResultList() {
        return resultList;
    }

    public void setResultList(Queue<Number> resultList) {
        this.resultList = resultList;
    }



    //기능 1 : input 숫자 정수인지 확인
    public int checkingInput(Scanner scanner, char operator) throws InputMismatchException, ArithmeticException {
        int input = scanner.nextInt();

        if (input < 0 && operator == ' ') {
            //정수만 입력
            throw new InputMismatchException("\n0을 포함한 양의 정수만 가능합니다. 재입력해주세요.");
        } else if (input == 0 && operator == '/') {
            //0으로 나누기 못함
            throw new ArithmeticException();
        } else {
            return input;
        }

    }

    //기능 2 : 잘못된 operator를 입력했는지 확인
    public char checkingOperator(Scanner scanner) throws IllegalArgumentException {

        char input = scanner.next().charAt(0);

        if(!(input == '+' || input == '-' || input == 'x' ||
                input == 'X' || input == '*' || input == '/')) {
            throw new IllegalArgumentException("목록 안에서만 입력해주세요");
        } else {
            return input;
        }

    }

    //연산 기능
    public Number calculate(int firstInput, int secondInput, char operator) {

        if (operator == '+') {
            return firstInput + secondInput;
        } else if (operator == '-') {
            return firstInput - secondInput;
        } else if (operator == 'x' || operator == '*' || operator == 'X') {
            return firstInput * secondInput;
        } else if (operator == '/') {
            if(firstInput%secondInput==0) {
                return firstInput / secondInput;
            } else {
                return (float)firstInput / secondInput;
            }
        }

        return null;
    }


    //출력 기능
    public void printResult(int firstInput, int secondInput, char operator, int result, float fResult, boolean isFloat) {
        if (isFloat) {
            System.out.println();
            System.out.println("["+ firstInput + " " + operator + " " + secondInput
                    + " " + "=" + " " + fResult +"]");
        } else {
            System.out.println();
            System.out.println("[" + firstInput + " " + operator + " " + secondInput
                    + " " + "=" + " " + result + "]");
        }
    }

    public void addResult(int result, float fResult) {
        if(fResult != 0 ) {
            this.resultList.add(fResult);
        } else {
            this.resultList.add(result);

        }

    }

    public void removeResult() {
        this.resultList.poll();
    }


}
