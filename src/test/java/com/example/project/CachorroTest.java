package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CachorroTest {

    private Cachorro cachorro;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redireciona System.out para capturar a saída
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        // Restaura System.out
        System.setOut(originalOut);
    }

    @Test
    public void testConstrutor() {
        cachorro = new Cachorro("Rex", "Labrador");

        assertEquals("Rex", cachorro.getNome());
        assertEquals("Labrador", cachorro.getRaca());
    }

    @Test
    public void testGetNome() {
        cachorro = new Cachorro("Bolinha", "Poodle");

        assertEquals("Bolinha", cachorro.getNome());
    }

    @Test
    public void testGetRaca() {
        cachorro = new Cachorro("Thor", "Pastor Alemão");

        assertEquals("Pastor Alemão", cachorro.getRaca());
    }

    @Test
    public void testSetNome() {
        cachorro = new Cachorro("Rex", "Labrador");
        cachorro.setNome("Max");

        assertEquals("Max", cachorro.getNome());
    }

    @Test
    public void testSetRaca() {
        cachorro = new Cachorro("Rex", "Labrador");
        cachorro.setRaca("Golden Retriever");

        assertEquals("Golden Retriever", cachorro.getRaca());
    }

    @Test
    public void testLatir() {
        cachorro = new Cachorro("Rex", "Labrador");
        cachorro.latir();

        String esperado = "Rex está latindo!";
        String obtido = outContent.toString().trim();

        assertEquals(esperado, obtido);
    }

    @Test
    public void testLatirComNomeDiferente() {
        cachorro = new Cachorro("Totó", "Vira-lata");
        cachorro.latir();

        String esperado = "Totó está latindo!";
        String obtido = outContent.toString().trim();

        assertEquals(esperado, obtido);
    }

    @Test
    public void testMultiplosLatidos() {
        cachorro = new Cachorro("Buddy", "Beagle");
        cachorro.latir();
        cachorro.latir();

        String esperado = "Buddy está latindo!" + System.lineSeparator() + "Buddy está latindo!";
        String obtido = outContent.toString().trim();

        assertEquals(esperado, obtido);
    }

    @Test
    public void testCachorroComNomeVazio() {
        cachorro = new Cachorro("", "Bulldog");

        assertEquals("", cachorro.getNome());
        assertEquals("Bulldog", cachorro.getRaca());
    }

    @Test
    public void testAlterarNomeERaca() {
        cachorro = new Cachorro("Spike", "Rottweiler");

        cachorro.setNome("Duke");
        cachorro.setRaca("Doberman");

        assertEquals("Duke", cachorro.getNome());
        assertEquals("Doberman", cachorro.getRaca());
    }
}
