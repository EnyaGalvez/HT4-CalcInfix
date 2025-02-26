package org.example.adt;

/**
 * Interfaz que define las operaciones básicas de una pila (Stack).
 *
 * @param <T> Tipo de datos almacenados en la pila.
 */
public interface Stack<T> {
    void push(T item);  // Agregar un elemento a la pila
    T pop();            // Sacar el elemento superior de la pila
    T peek();           // Ver el elemento superior sin sacarlo
    boolean isEmpty();  // Verificar si la pila está vacía
}
