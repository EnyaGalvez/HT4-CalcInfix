package org.example.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ListTest {
    
    @Test
    void testSimpleLinkedList() {
        List<Integer> list = new SimpleLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        assertEquals(20, list.removeFirst());
        assertEquals(10, list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    void testDoubleLinkedList() {
        List<Integer> list = new DoubleLinkedList<>();
        list.addFirst(30);
        list.addFirst(40);
        assertEquals(40, list.removeFirst());
        assertEquals(30, list.removeFirst());
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveFromEmptyList() {
        List<Integer> list = new SimpleLinkedList<>();
        assertThrows(IllegalStateException.class, list::removeFirst);
    }
}
