package org.example.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StackTest {
    
    @Test
    void testArrayListStack() {
        Stack<Integer> stack = new ArrayListStack<>();
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void testVectorStack() {
        Stack<Integer> stack = new VectorStack<>();
        stack.push(5);
        stack.push(15);
        assertEquals(15, stack.pop());
        assertEquals(5, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void testListStack() {
        Stack<Integer> stack = new ListStack<>(new SimpleLinkedList<>());
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPopOnEmptyStack() {
        Stack<Integer> stack = new ArrayListStack<>();
        assertThrows(IllegalStateException.class, stack::pop);
    }
}
