package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        //반복실행 종료 변수 선언 및 초기화
        String Exit = "continue";
        //정수 및 사칙연산 기호 입력받기 위한 Scanner 사용
        Scanner sc = new Scanner(System.in);

        //반복문 실행
        while (!Exit.equals("exit")) {

            //양의 정수 입력받기
            System.out.println("첫 번째 숫자를 입력하세요: ");
            int number1 = sc.nextInt();

            //사칙연산 기호 입력받기(CharAt() 사용)
            System.out.println("사칙연산 기호를 입력하세요: (+, -, *, /)");
            char operator = sc.next().charAt(0);

            //양의 정수 입력받기
            System.out.println("두 번째 숫자를 입력하세요: ");
            int number2 = sc.nextInt();

            //if 사용하여 사칙연산 수행
            if (operator == '+') {
                int result = number1 + number2;
                System.out.println("결과: " + result);
            } else if (operator == '-') {
                int result = number1 - number2;
                System.out.println("결과: " + result);
            } else if (operator == '*') {
                int result = number1 * number2;
                System.out.println("결과: " + result);
            } else if (operator == '/') {
                double result = (double) number1 / number2;
                System.out.println("결과: " + result);

                if (number2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
            } else {
                System.out.println("올바르지 않은 연산자입니다.");
            }
            //반복실행 종료키 입력받기
            System.out.println("더 계산하시겠습니까? press any button. (exit 입력 시 종료)");
            Exit = sc.next();

        }
    }
}