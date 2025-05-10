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
        boolean isFloat = false;
        char operator;



        while (true) {

            //첫 번재 숫자 입력 반복문
            while (true) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    first = scanner.nextInt();

                    if (first < 0) {
                        System.out.println("\n0을 포함한 양의 정수만 가능합니다. 재입력해주세요.");
                        continue;
                    }

                    break;

                } catch (InputMismatchException e) {
                    //int 말고 다른 걸 입력했을 경우
                    System.out.println("정수만 입력 가능합니다. 다시 입력해주세요.");
                    scanner.nextLine();
                    System.out.println();
                }

            }


            //두 번째 숫자 입력 반복문
            while (true) {
                try {

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    second = scanner.nextInt();

                    if (second < 0) {
                        System.out.println("\n0을 포함한 양의 정수만 가능합니다. 재입력해주세요.");
                        continue;
                    }

                    break;

                } catch (InputMismatchException e) {
                    //int 말고 다른 걸 입력했을 경우
                    System.out.println("정수만 입력 가능합니다. 다시 입력해주세요.");
                    scanner.nextLine();
                    System.out.println();
                }


            }


            //입력한 숫자 보여주기
            System.out.println();
            System.out.println("입력한 숫자");
            System.out.println("["+first + "," +  second +"]");



            // 연산자 기호 입력 반복분
            while (true) {

                System.out.println();
                System.out.println("기호를 적어주세요");
                System.out.println(" + , - , x , / ");
                operator = scanner.next().charAt(0);


                if (operator == '+' || operator == '-' || operator == 'x' ||
                        operator == 'X' || operator == '*' || operator == '/') {
                    break;
                } else {
                    System.out.println();
                    System.out.println("목록 안에서만 입력해주세요");
                    continue;
                }
            }



            //나눗셈 할 때 분모(두번째 숫자)가 0일 경우
            if(operator == '/'){
                while (second == 0){
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");

                    //다시 두번째 숫자만 입력
                    try {
                        System.out.println();
                        System.out.print("두 번째 숫자를 입력하세요: ");
                        second = scanner.nextInt();

                        if (second < 0) {
                            System.out.println("\n0을 포함한 양의 정수만 가능합니다. 재입력해주세요.");
                            continue;
                        }

                    } catch (InputMismatchException e) {
                        //int말고 다른 걸 입력했을 경우
                        System.out.println("정수만 입력 가능합니다. 다시 입력해주세요.");
                        scanner.nextLine();
                        System.out.println();
                    }
                }
            }




            //연산
            if (operator == '+') {
                result = (int)first + second;
            } else if (operator == '-') {
                result = first - second;
            } else if (operator == 'x' || operator == '*' || operator == 'X') {
                result = first * second;
            } else if (operator == '/') {
                if(first%second != 0) {
                    fResult = (float) first / second;
                    isFloat = true;
                } else {
                    result = first / second;
                }
            }



            System.out.println();


            //출력
            if (operator == '/' && isFloat) {
                System.out.println();
                System.out.println("["+ first + " " + operator + " " + second
                        + " " + "=" + " " + fResult +"]");
            } else {
                System.out.println();
                System.out.println("[" + first + " " + operator + " " + second
                        + " " + "=" + " " + result + "]");
            }



            // exit 입력시 계산기 종료 or 재실행
            System.out.println();
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            scanner.nextLine();
            String answer = scanner.nextLine();

            if(answer.equals("exit")){
                System.out.println("계산기 종료");
                break;
            }

            System.out.println();
            System.out.println("(재실행)");
            System.out.println();

        }


        scanner.close();

    }
}
