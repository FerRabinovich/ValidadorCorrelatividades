package com.validadorcorrelativas.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MateriaTest {
    private Materia materia;

    @Before
    public void setUp() {
        materia = new Materia();
        materia.setNombre("Analisis Matematico 2");
        materia.setAprobada(true);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Analisis Matematico 2", materia.getNombre());
    }

    @Test
    public void testGetAprobada() {
        assertTrue(materia.getAprobada());
    }

    @Test
    public void testSetCorrelativas() {
        Materia correlativa = new Materia();
        correlativa.setNombre("Algebra");

        List<Materia> correlativas = new ArrayList<Materia>();
        correlativas.add(correlativa);

        materia.setCorrelativas(correlativas);
        assertEquals(1, materia.getCorrelativas().size());
        assertTrue(materia.getCorrelativas().contains(correlativa));
    }

}