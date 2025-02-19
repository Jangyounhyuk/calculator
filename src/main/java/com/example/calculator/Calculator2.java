package com.example.calculator;

import java.util.ArrayList;

//계산기 기능 클래스
public class Calculator2 {

    //캡슐화하여 컬랙션 필드 생성
    //ArrayList -> list
    private ArrayList<Double> results = new ArrayList<>();
    private int number1;
    private char operator;
    private int number2;


    //사칙연산 수행 및 결과값 반환 메서드
    public double calculate(int number1, char operator, int number2) throws ArithmeticException, OperatorInputException {
        double result;
        this.number1 = number1;
        this.operator = operator;
        this.number2 = number2;

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
                //System.out.println("0으로 나눌 수 없습니다.");
            }
            result = (double) number1 / number2;
        } else {
            throw new OperatorInputException();
        }
        return result;
    }

    //연산 결과 저장 메서드
    public void store(double resultValue) {
        results.add(resultValue);
    }

    //Getter 메서드(특정 연산 결과 조회)
    public double getResults(int index) throws IndexOutOfBoundsException {
        if(index <= 0 || index > results.size()) {
            throw new IndexOutOfBoundsException("연산 값이 존재하지 않습니다.");
        } else return results.get(index-1);
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
