package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //Calculator2 클래스를 통한 객체 생성
        Calculator2 calculator2 = new Calculator2();

        //반복실행 종료 변수 선언 및 초기화
        String Exit = "continue";
        //정수 및 사칙연산 기호 입력받기 위한 Scanner 사용
        Scanner sc = new Scanner(System.in);

        //반복문 실행
        while (!Exit.equals("exit")) {
            double result = 0;
            //양의 정수 입력받기
            System.out.println("첫 번째 숫자를 입력하세요: ");
            int number1 = sc.nextInt();

            //사칙연산 기호 입력받기(CharAt() 사용)
            System.out.println("사칙연산 기호를 입력하세요(+, -, *, /): ");
            char operator = sc.next().charAt(0);

            //양의 정수 입력받기
            System.out.println("두 번째 숫자를 입력하세요: ");
            int number2 = sc.nextInt();

            try {
                //Calculator2 클래스의 calculate() 메서드를 통해 연산 수행
                result = calculator2.calculate(number1, operator, number2);
                //결과 출력
                System.out.println("결과 : " + result);
            }
            catch (ArithmeticException | OperatorInputException e) {
                System.out.println(e.getMessage());
            }

            //반복실행 종료키 입력받기
            System.out.println("더 계산하시겠습니까? press any button. (exit 입력 시 종료)");
            Exit = sc.next();

            //연산 결과 Calculator2 클래스의 store() 메서드를 통해 저장
            calculator2.store(result);
        }

        //연산 결과 조회
        System.out.println("몇 번째 연산 결과를 조회하시겠습니까?");
        int getIndex = sc.nextInt();
        //0 이하의 수 또는 ArrayList 의 크기보다 큰 수를 index 로 입력하였을 때 발생하는 오류 방지
        try {
            calculator2.getResults(getIndex);
            System.out.println(getIndex + " 번째 연산 결과: " + calculator2.getResults(getIndex));
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        //연산 결과 수정 후 결과 확인
        System.out.println("몇 번째 연산 결과를 수정하시겠습니까?");
        int setIndex = sc.nextInt();
        //0 이하의 수 또는 ArrayList 의 크기보다 큰 수를 index 로 입력하였을 때 발생하는 오류 방지
        if (setIndex <= 0 || setIndex > calculator2.length()) {
            System.out.println("연산 값이 존재하지 않습니다.");
        } else {
            System.out.println("수정할 값을 입력해주시오");
            double valueToRevise = sc.nextInt();
            calculator2.setResults(setIndex, valueToRevise);
            System.out.println("수정된 " + setIndex + " 번째 연산 결과: " + calculator2.getResults(setIndex));
        }

        //Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능
        System.out.println("첫 연산 결과를 지우려면 숫자 '1'을 입력하시오.");
        System.out.println("첫 연산 결과를 지우지 않으려면 '1'을 제외한 아무 숫자나 입력하시오.");
        int remove = sc.nextInt();
        if (remove == 1) {
            calculator2.remove();
            //연산 결과 삭제가 잘 적용되었는지 확인해줌
            System.out.println("연산 결과 : " + calculator2.getAllResults());
        } else {
            //연산 결과가 삭제되지 않았는지 확인해줌
            System.out.println("연산 결과 : " + calculator2.getAllResults());
        }
    }

}
