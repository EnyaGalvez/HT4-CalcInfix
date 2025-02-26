package org.example.adt;

/**
 * Implementación de una lista simplemente encadenada.
 *
 * @param <T> Tipo de datos almacenados en la lista.
 */
public class SimpleLinkedList<T> implements List<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    public SimpleLinkedList() {
        head = null;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: La lista está vacía.");
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
