package com.validadorcorrelativas.middleware;

import com.validadorcorrelativas.model.Alumno;
import com.validadorcorrelativas.model.Inscripcion;
import com.validadorcorrelativas.model.Materia;

public class Validador {

    public Validador() {
        super();
    }

    public boolean Validar(Materia materia, Alumno alumno, Inscripcion inscripcion) {
        return inscripcion.aprobada(materia, alumno);
    }
}
