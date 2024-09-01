package org.example.calculatorsite.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(double operand1, double operand2, String operator){
        System.out.println("Operand1: " + operand1);
        System.out.println("Operand2: " + operand2);
        System.out.println("Operator: " + operator);
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
            default:
                throw new IllegalArgumentException("Неизвестный оператор" + operator);
        }
    }
}
