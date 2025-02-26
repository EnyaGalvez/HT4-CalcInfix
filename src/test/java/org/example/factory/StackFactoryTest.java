package org.example.factory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.example.adt.ArrayListStack;
import org.example.adt.DoubleLinkedList;
import org.example.adt.SimpleLinkedList;
import org.example.adt.Stack;
import org.junit.jupiter.api.Test;

public class StackFactoryTest {
    
    @Test
    void testCrearArrayListStack() {
        Stack<Integer> stack = StackFactory.createStack(1, null);
        assertTrue(stack instanceof ArrayListStack);
    }

    @Test
    void testCrearVectorStack() {
        Stack<Integer> stack = StackFactory.createStack(2, null);
        assertTrue(stack instanceof VectorStack);
    }

    @Test
    void testCrearListStackConSimpleLinkedList() {
        Stack<Integer> stack = StackFactory.createStack(3, new SimpleLinkedList<>());
        assertTrue(stack instanceof ListStack);
    }

    @Test
    void testCrearListStackConDoubleLinkedList() {
        Stack<Integer> stack = StackFactory.createStack(3, new DoubleLinkedList<>());
        assertTrue(stack instanceof ListStack);
    }

    @Test
    void testCrearListStackSinLista() {
        assertThrows(NoSuchElementException.class, () -> StackFactory.createStack(3, null));
    }
}
