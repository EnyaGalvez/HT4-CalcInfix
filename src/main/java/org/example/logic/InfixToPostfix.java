package org.example.logic;

import org.example.adt.Stack;
import org.example.factory.StackFactory;

public class InfixToPostfix {
    public static String convert(String infixExpression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = StackFactory.createStack(1, null); // Usa ArrayListStack
        String operators = "+-*/";

        for (char c : infixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c).append(" "); // Agrega números al resultado
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop(); // Elimina el '(' de la pila
            } else if (operators.indexOf(c) != -1) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        // Vaciar la pila de operadores restantes
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    private static int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return -1;
        }
    }
}
