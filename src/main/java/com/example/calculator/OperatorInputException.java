package com.example.calculator;

//연산부호 오입력 예외처리 클래스
public class OperatorInputException extends Exception {
    public OperatorInputException() {
        super("사칙연산 기호를 입력하세요(+, -, *, /)");
    }
}