package org.example;

import org.example.adt.*;
import org.example.factory.StackFactory;
import org.example.logic.InfixToPostfix;
import org.example.logic.PostfixEvaluator;
import org.example.logic.CalculatorSingleton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer expresión desde el archivo datos.txt
        String filePath = "src/main/resources/datos.txt";
        String infixExpression = "";
        try {
            infixExpression = new String(Files.readAllBytes(Paths.get(filePath))).trim();
        } catch (IOException e) {
            System.out.println("Error: No se pudo leer el archivo datos.txt.");
            return;
        }

        System.out.println("Expresión infix leída del archivo: " + infixExpression);

        // Preguntar al usuario qué implementación de pila desea usar
        System.out.println("Seleccione la implementación de la pila:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista simplemente encadenada");
        System.out.print("Ingrese su opción (1-3): ");
        int pilaOpcion = scanner.nextInt();

        Stack<Integer> stack = null;
        List<Integer> list = null;

        if (pilaOpcion == 3) {  // Si elige lista, preguntar qué tipo de lista usar
            System.out.println("Seleccione la implementación de la lista:");
            System.out.println("1. Lista simplemente encadenada");
            System.out.println("2. Lista doblemente encadenada");
            System.out.print("Ingrese su opción (1-2): ");
            int listaOpcion = scanner.nextInt();

            if (listaOpcion == 1) {
                list = new SimpleLinkedList<>();
            } else if (listaOpcion == 2) {
                list = new DoubleLinkedList<>();
            } else {
                System.out.println("Opción no válida. Se usará lista simplemente encadenada por defecto.");
                list = new SimpleLinkedList<>();
            }
        }

        // Crear la pila con la opción seleccionada
        stack = StackFactory.createStack(pilaOpcion, list);

        if (stack == null) {
            System.out.println("Error: No se pudo crear la pila.");
            return;
        }

        // Convertir de infix a postfix
        String postfixExpression = InfixToPostfix.convert(infixExpression);
        System.out.println("Expresión en postfix: " + postfixExpression);

        // Evaluar la expresión postfix
        CalculatorSingleton calculator = CalculatorSingleton.getInstance();
        int resultado = calculator.evaluate(postfixExpression, stack);
        System.out.println("Resultado de la expresión: " + resultado);

        scanner.close();
    }
}
