package com.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int first =0;
        int second = 0;
        int result = 0;
        float fResult = 0;
        char operator;



        while (true) {

            while (true) {

                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    first = scanner.nextInt();

                    if (first >= 0) {
                        break;
                    } else {
                        System.out.println("\n0을 포함한 양의 정수만 가능합니다. 재입력해주세요.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("정수만 입력 가능합니다. 다시 입력해주세요.");
                    scanner.nextLine();
                    System.out.println();
                }

            }

            while (true) {


                try {

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    second = scanner.nextInt();

                    if (second < 0) {
                        System.out.println("\n0을 포함한 양의 정수만 가능합니다. 재입력해주세요.");
                        continue;
                    }

                    System.out.println();
                    System.out.println("입력한 숫자");
                    System.out.println("["+first + "," +  second +"]");


                    while (true) {

                        System.out.println();
                        System.out.println("기호를 적어주세요");
                        System.out.println(" + , - , x , / ");
                        operator = scanner.next().charAt(0);

                        if (operator == '/' && second == 0) {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            continue;
                        } else if (operator == '+') {
                            result = (int)first + second;
                            break;
                        } else if (operator == '-') {
                            result = first - second;
                            break;
                        } else if (operator == 'x' || operator == '*' || operator == 'X') {
                            result = first * second;
                            break;
                        } else if (operator == '/') {
                            fResult = (float) first / second;
                            break;
                        } else {
                            System.out.println();
                            System.out.println("목록 안에서만 입력해주세요");
                            continue;
                        }


                    }

                    break;

                } catch (InputMismatchException e) {
                    System.out.println("정수만 입력 가능합니다. 다시 입력해주세요.");
                    scanner.nextLine();
                    System.out.println();
                }



            }





            System.out.println();


            //출력
            if(operator == '+' || operator == '-' || operator == 'x'|| operator == 'X' || operator == '*') {
                System.out.println("[" + first + " " + operator + " " + second
                        + " " + "=" + " " + result + "]");
            } else if (operator == '/') {
                System.out.println();
                System.out.println("["+ first + " " + operator + " " + second
                        + " " + "=" + " " + fResult +"]");
            }


            System.out.println();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            scanner.nextLine();
            String answer = scanner.nextLine();

            if(answer.equals("exit")){
                System.out.println("계산기 종료");
                break;
            }

            System.out.println();
            System.out.println("재실행");
            System.out.println();

        }


        scanner.close();

    }
}
