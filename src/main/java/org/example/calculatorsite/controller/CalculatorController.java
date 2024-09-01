package org.example.calculatorsite.controller;

import org.example.calculatorsite.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculate")
    public ResponseEntity<?> calculate(
            @RequestParam double operand1,
            @RequestParam double operand2,
            @RequestParam String operator) {
        System.out.println("Operand1: " + operand1);
        System.out.println("Operand2: " + operand2);
        System.out.println("Operator: " + operator);

        try {
            double result = calculatorService.calculate(operand1, operand2, operator);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
