package com.validadorcorrelativas.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AlumnoTest {
    private Alumno alumno;
    private Materia materiaAprobada;
    private Materia materiaNoAprobada;

    @Before
    public void setUp() {
        alumno = new Alumno();
        materiaAprobada = new Materia();
        materiaAprobada.setNombre("Analisis Matematico 1");
        materiaAprobada.setAprobada(true);

        materiaNoAprobada = new Materia();
        materiaNoAprobada.setNombre("Fisica");
        materiaNoAprobada.setAprobada(false);
    }

    @Test
    public void testSetMateriaAprobada() {
        alumno.setMateriaAprobada(materiaAprobada);
        assertEquals(1, alumno.getMateriasAprobadas().size());
        assertTrue(alumno.getMateriasAprobadas().contains(materiaAprobada));
    }

    @Test
    public void testNoAgregarMateriaNoAprobada() {
        alumno.setMateriaAprobada(materiaNoAprobada);
        assertEquals(0, alumno.getMateriasAprobadas().size());
    }

    @Test
    public void testNoAgregarMateriaDuplicada() {
        alumno.setMateriaAprobada(materiaAprobada);
        assertEquals(1, alumno.getMateriasAprobadas().size());
    }
}
