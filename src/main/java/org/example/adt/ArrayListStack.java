package org.example.adt;

import java.util.ArrayList;

/**
 * Implementación de una pila usando ArrayList.
 *
 * @param <T> Tipo de datos almacenados en la pila.
 */
public class ArrayListStack<T> implements Stack<T> {
    private ArrayList<T> stack;

    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: La pila está vacía.");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: La pila está vacía.");
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
