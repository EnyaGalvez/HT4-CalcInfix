package org.example.logic;

import org.example.adt.Stack;
import org.example.factory.StackFactory;

public class PostfixEvaluator {
    public static int evaluate(String postfixExpression) {
        Stack<Integer> stack = StackFactory.createStack(1, null); // Usa ArrayListStack
        String[] tokens = postfixExpression.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token)); // Agrega números a la pila
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(token, a, b);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+"); // Verifica si es un número
    }

    private static int applyOperator(String operator, int a, int b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return (b != 0) ? a / b : 0; // Evita división por cero
            default: throw new IllegalArgumentException("Operador inválido: " + operator);
        }
    }
}
