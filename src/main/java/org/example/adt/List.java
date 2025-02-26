package org.example.adt;

/**
 * Interfaz que define una lista genérica.
 *
 * @param <T> Tipo de datos almacenados en la lista.
 */
public interface List<T> {
    void addFirst(T item);  // Agregar un elemento al inicio
    T removeFirst();        // Eliminar el primer elemento
    boolean isEmpty();      // Verificar si la lista está vacía
}
