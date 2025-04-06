package com.validadorcorrelativas.middleware;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.validadorcorrelativas.model.Alumno;
import com.validadorcorrelativas.model.Inscripcion;
import com.validadorcorrelativas.model.Materia;

public class ValidadorTest {

    private Validador validador;
    private Alumno alumno;
    private Inscripcion inscripcion;
    private Materia materia1;
    private Materia materia2;
    private Materia materia3;

    @Before
    public void setUp() {
        validador = new Validador();
        alumno = new Alumno();
        inscripcion = new Inscripcion();

        // Crear materias
        materia1 = new Materia();
        materia1.setNombre("Analisis Matematico 1");
        materia1.setAprobada(true);

        materia2 = new Materia();
        materia2.setNombre("Fisica");
        materia2.setAprobada(true);

        materia3 = new Materia();
        materia3.setNombre("Quimica");
        materia3.setAprobada(false);
    }

    @Test
    public void testValidarMateriaSinCorrelativas() {
        // Materia sin correlativas
        assertTrue(validador.Validar(materia1, alumno, inscripcion));
    }

    @Test
    public void testValidarMateriaConCorrelativas() {
        // Configurar correlativas
        materia3.setCorrelativas(Arrays.asList(materia1));

        // Alumno aprueba la materia correlativa
        alumno.setMateriaAprobada(materia1);

        // Validar que el alumno puede inscribirse
        assertTrue(validador.Validar(materia3, alumno, inscripcion));
    }

    @Test
    public void testValidarMateriaConCorrelativasNoAprobadas() {
        // Configurar correlativas
        materia3.setCorrelativas(Arrays.asList(materia1));

        // Alumno no aprueba la materia correlativa
        alumno.setMateriaAprobada(materia2); // Aprobó Física, no Matemáticas

        // Validar que el alumno no puede inscribirse
        assertFalse(validador.Validar(materia3, alumno, inscripcion));
    }

    @Test
    public void testValidarMateriaConCorrelativasSinMateriasAprobadas() {
        // Configurar correlativas
        materia3.setCorrelativas(Arrays.asList(materia1));

        // Alumno no tiene materias aprobadas
        assertFalse(validador.Validar(materia3, alumno, inscripcion));
    }
}
