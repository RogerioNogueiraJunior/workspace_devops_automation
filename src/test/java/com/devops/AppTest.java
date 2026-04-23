package com.devops;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AppTest {
    @Test
    public void testAppExists() {
        // Teste básico de sanidade — valida que a classe existe e é instanciável
        App app = new App();
        assertTrue(app != null);
    }
}