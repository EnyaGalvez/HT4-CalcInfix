package org.example.factory;

import org.example.adt.*;
import java.util.NoSuchElementException;

public class StackFactory {

    /**
     * Crea una pila (Stack) según la opción del usuario.
     *
     * @param option Opción seleccionada (1 = ArrayList, 2 = Vector, 3 = Lista).
     * @param list Lista a utilizar si la opción es 3 (puede ser SimpleLinkedList o DoubleLinkedList).
     * @return Una instancia de Stack con la implementación deseada.
     */
    public static <T> Stack<T> createStack(int option, List<T> list) {
        switch (option) {
            case 1:
                return new ArrayListStack<>();
            case 2:
                return new VectorStack<>();
            case 3:
                if (list == null) {
                    throw new NoSuchElementException("Error: Se necesita una lista para implementar la pila basada en listas.");
                }
                return new ListStack<>(list);
            default:
                throw new IllegalArgumentException("Opción no válida. Debe ser 1 (ArrayList), 2 (Vector) o 3 (Lista).");
        }
    }
}
