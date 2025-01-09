package com.example.calculator;

import java.util.ArrayList;

//계산기 기능 클래스
public class Calculator2 {

    //캡슐화하여 컬랙션 필드 생성
    //new ArrayList<Double>(); 으로 하면 명시적 형변환 주의문구?
    //ArrayList -> list
    private ArrayList<Double> results = new ArrayList<>();

    //사칙연산 수행 및 결과값 반환 메서드
    public double calculate(int number1, char operator, int number2) throws ArithmeticException {
        double result = 0;

        if (operator == '+') {
            result = number1 + number2;
        } else if (operator == '-') {
            result = number1 - number2;
        } else if (operator == '*') {
            result = number1 * number2;
        } else if (operator == '/') {
            if (number2 == 0) {
                //분모에 0을 기입할 시 예외처리
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
//                System.out.println("0으로 나눌 수 없습니다.");
            }
            result = (double) number1 / number2;
        } else {
            System.out.println("사칙연산 기호를 올바르게 입력하세요(+, -, *, /)");
        }
        return result;
    }

    //연산 결과 저장 메서드
    public void store(double resultValue) {
        results.add(resultValue);
    }

    //Getter 메서드(특정 연산 결과 조회)
    public double getResults(int index) {
        return results.get(index-1);
    }

    //Setter 메서드
    public void setResults(int index, double revisedValue) {
        results.set(index-1,revisedValue);
    }

    //Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능
    public void remove() {
        results.remove(0);
    }

    //Getter 메서드(모든 연산 결과 조회)
    public ArrayList<Double> getAllResults() {
        return results;
    }

    //컬랙션의 크기 조회(Getter, setter 메서드 사용 시 오류 방지)
    public int length() {
        return results.size();
    }
}
