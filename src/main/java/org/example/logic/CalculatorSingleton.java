package org.example.logic;

import org.example.adt.Stack;

public class CalculatorSingleton {
    private static CalculatorSingleton instance; // Instancia única de la clase

    private CalculatorSingleton() {
        // Constructor privado para evitar instanciación directa
    }

    public static CalculatorSingleton getInstance() {
        if (instance == null) {
            instance = new CalculatorSingleton();
        }
        return instance;
    }

    public int evaluate(String postfixExpression, Stack<Integer> stack) {
        String[] tokens = postfixExpression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token)); // Empuja números a la pila
            } else {
                // Extrae los dos operandos de la pila
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(token, a, b);
                stack.push(result); // Apila el resultado
            }
        }

        return stack.pop(); // El resultado final está en la cima de la pila
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+"); // Verifica si es un número (positivo o negativo)
    }

    private int applyOperator(String operator, int a, int b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return (b != 0) ? a / b : 0; // Evitar división por cero
            default: throw new IllegalArgumentException("Operador inválido: " + operator);
        }
    }
}
