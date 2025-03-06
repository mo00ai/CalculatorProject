package com.example.calculator;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ArithmeticCalculator<T extends Number> {

    OperatorType operatorType;

    //필드
    private Queue<T> resultList = new LinkedList<>();

    //생성자


    //게터 세터
    public Queue<T> getResultList() {
        return resultList;
    }

    public void setResultList(Queue<T> resultList) {
        this.resultList = resultList;
    }



    //기능 1 : input 숫자 정수인지 확인
    public T checkingInput(Scanner scanner, char operator) throws InputMismatchException, ArithmeticException {

        if(scanner.hasNextInt()) {
            int input = scanner.nextInt();

            if (input < 0 && operator == ' ') {
                //정수만 입력
                throw new InputMismatchException("\n0을 포함한 양의 정수만 가능합니다. 재입력해주세요.");
            } else if (input == 0 && operator == OperatorType.DIVIDE.getValue()) {
                //0으로 나누기 못함
                throw new ArithmeticException();
            } else {
                return (T) Integer.valueOf(input);
            }

        } else if (scanner.hasNextDouble()) {
            double input = scanner.nextDouble();

            if (input < 0.0 && operator == ' ') {
                //정수만 입력
                throw new InputMismatchException("\n0을 포함한 양의 정수만 가능합니다. 재입력해주세요.");
            } else if (input == 0 && operator == OperatorType.DIVIDE.getValue()) {
                //0으로 나누기 못함
                throw new ArithmeticException();
            } else {
                return (T) Double.valueOf(input) ;
            }

        } else  {
            throw new InputMismatchException("숫자만 입력해주세요.");
        }


    }

    //기능 2 : 잘못된 operator를 입력했는지 확인
    public char checkingOperator(Scanner scanner) throws IllegalArgumentException {

        char input = scanner.next().charAt(0);

        if(!(OperatorType.contains(input))) {
            throw new IllegalArgumentException("목록 안에서만 입력해주세요");
        } else {
            return input;
        }

    }

    //연산 기능
    public T calculate(T firstInput, T secondInput, char operator) {

        double first = firstInput.doubleValue();
        double second = secondInput.doubleValue();
        double result = 0;

        if (operator == '+') {
            result = first + second;
        } else if (operator == '-') {
            result = first - second;
        } else if ( operator == '*' ) {
            result = first * second;
        } else if (operator == '/') {
            result = first / second;
        }

        if(result % 1==0) {
            return (T) Integer.valueOf((int)result);
        } else {
            return (T) Double.valueOf(result);
        }

    }


    //출력 기능
    public void printResult(T firstInput, T secondInput, char operator, T result) {

            System.out.println();
            System.out.println("[" + firstInput + " " + operator + " " + secondInput
                    + " " + "=" + " " + result + "]");

    }

    public void addResult(T result) {

        this.resultList.add(result);

    }

    public void removeResult() {
        this.resultList.poll();
    }


    //입력값보다 더 큰 결과값들을 출력
    public void printBiggerInput(T input) {

        this.resultList
                .stream()
                .filter(result -> result.doubleValue() > input.doubleValue())
                .forEach(System.out::println);

    }




}
