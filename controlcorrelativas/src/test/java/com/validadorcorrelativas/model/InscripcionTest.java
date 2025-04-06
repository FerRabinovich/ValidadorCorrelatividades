package com.validadorcorrelativas.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InscripcionTest {
    private Inscripcion inscripcion;
    private Alumno alumno;
    private Materia materia;
    private Materia correlativa;

    @Before
    public void setUp() {
        inscripcion = new Inscripcion();
        alumno = new Alumno();

        materia = new Materia();
        materia.setNombre("DDS");
        materia.setAprobada(true);

        correlativa = new Materia();
        correlativa.setNombre("Gestion de datos");
        correlativa.setAprobada(true);

        List<Materia> correlativas = new ArrayList<Materia>();
        correlativas.add(correlativa);
        materia.setCorrelativas(correlativas);

        alumno.setMateriaAprobada(correlativa);
    }

    @Test
    public void testAprobadaConCorrelativa() {
        assertTrue(inscripcion.aprobada(materia, alumno));
    }

    @Test
    public void testPuedeInscribirseSinCorrelativas() {
        materia.setCorrelativas(new ArrayList<>());
        assertTrue(inscripcion.aprobada(materia, alumno));
    }
}