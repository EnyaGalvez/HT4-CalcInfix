package org.example.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InfixToPostfixTest {
    
    @Test
    void testConversionSimple() {
        assertEquals("3 5 +", InfixToPostfix.convert("3+5"));
    }

    @Test
    void testConversionConParentesis() {
        assertEquals("3 5 + 2 *", InfixToPostfix.convert("(3+5)*2"));
    }

    @Test
    void testConversionConOperadoresDiferentes() {
        assertEquals("8 2 5 * + 1 3 2 * + 4 - /", InfixToPostfix.convert("(8+2*5)/(1+3*2-4)"));
    }
}
