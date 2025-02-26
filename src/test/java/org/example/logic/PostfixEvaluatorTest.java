package org.example.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PostfixEvaluatorTest {
    
    @Test
    void testEvaluacionSimple() {
        assertEquals(8, PostfixEvaluator.evaluate("3 5 +"));
    }

    @Test
    void testEvaluacionMultiplicacion() {
        assertEquals(16, PostfixEvaluator.evaluate("4 4 *"));
    }

    @Test
    void testEvaluacionCompleja() {
        assertEquals(4, PostfixEvaluator.evaluate("8 2 /"));
    }

    @Test
    void testDivisionPorCero() {
        assertEquals(0, PostfixEvaluator.evaluate("5 0 /"));
    }
}
