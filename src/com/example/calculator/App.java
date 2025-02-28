package com.example.calculator;


import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int firstInput =0;
        int secondInput = 0;
        int result = 0;
        float fResult = 0;
        boolean isFloat = false;
        char operator = ' ';

        Calculator calculator = new Calculator();



        //수행이 잘되면 ㄱㅊ
        //방향성 없는 고민

        //lv 2
        //클래스 분리 역할 부여 - 역할을 분리해낼 수 있을까





        while (true) {

            firstInput = 0;
            secondInput = 0;
            result = 0;
            fResult = 0;
            isFloat = false;
            operator = ' ';


            System.out.println("resultList = "+calculator.resultList.toString());

            //첫 번재 숫자 입력 반복문
            while (true) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    firstInput = calculator.checkingInput(scanner , operator);
                    break;

                } catch (InputMismatchException e) {
                    //int 말고 다른 걸 입력했을 경우
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                    System.out.println();
                }

            }



            //두 번째 숫자 입력 반복문
            while (true) {
                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    secondInput = calculator.checkingInput(scanner, operator);
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
            System.out.println("["+firstInput + "," +  secondInput +"]");



            // 연산자 기호 입력 반복문
            while (true) {
                try {
                    System.out.println();
                    System.out.println(" + , - , x , / ");
                    System.out.print("기호를 적어주세요: ");

                    operator = calculator.checkingOperator(scanner);
                    break;

                } catch (IllegalArgumentException e) {
                    System.out.println();
                    System.out.println(e.getMessage());
                }

            }



            //나눗셈 할 때 분모(두번째 숫자)가 0일 경우
            if(operator == '/'){
                while (secondInput == 0){
                    System.out.println();
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    //다시 두번째 숫자만 입력
                    try {
                        System.out.print("두 번째 숫자를 입력하세요: ");
                        secondInput = calculator.checkingInput(scanner,operator);
                        break;

                    } catch (InputMismatchException e) {
                        //int 말고 다른 걸 입력했을 경우
                        System.out.println(e.getMessage());
                        scanner.nextLine();
                        System.out.println();
                    } catch (ArithmeticException e) {
                        System.out.println();
                    }
                }
            }




            //연산
            if ( firstInput % secondInput == 0 || !(operator == '/')){
                result = calculator.calculate(firstInput, secondInput, operator).intValue();
            } else {
                fResult = calculator.calculate(firstInput, secondInput, operator).floatValue();
                isFloat = true;
            }


            calculator.addResult(result,fResult);

            System.out.println("resultList = "+calculator.resultList.toString());


            System.out.println();


            //출력
            calculator.printResult(firstInput,secondInput,operator,result,fResult,isFloat);



            // exit 입력시 계산기 종료 or 재실행
            System.out.println();
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            scanner.nextLine();
            String answer = scanner.nextLine();

            if(answer.equals("exit")){
                System.out.println("계산기 종료");
                calculator.removeResult();
                break;
            }

            calculator.removeResult();

            System.out.println();
            System.out.println("(재실행)");
            System.out.println("resultList = "+calculator.resultList.toString());
            System.out.println();
        }

        scanner.close();



    }
}
