package org.example.adt;

/**
 * Implementación de una lista doblemente encadenada.
 *
 * @param <T> Tipo de datos almacenados en la lista.
 */
public class DoubleLinkedList<T> implements List<T> {
    private static class Node<T> {
        T data;
        Node<T> prev, next;

        Node(T data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    private Node<T> head;

    public DoubleLinkedList() {
        head = null;
    }

    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: La lista está vacía.");
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
