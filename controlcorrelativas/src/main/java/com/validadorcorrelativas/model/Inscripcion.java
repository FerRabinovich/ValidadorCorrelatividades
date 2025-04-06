package com.validadorcorrelativas.model;

public class Inscripcion {

    public Inscripcion() {
        super();
    }

    public boolean aprobada(Materia materia, Alumno alumno) {
        if (materia.getCorrelativas().isEmpty())
            return true;

        if (alumno.getMateriasAprobadas().isEmpty())
            return false;

        for (Materia alumnoMateriaAprobada : alumno.getMateriasAprobadas()) {
            if (!materia.getCorrelativas().stream().anyMatch(x -> x.getNombre() == alumnoMateriaAprobada.getNombre()))
                return false;
        }

        return true;
    }
}
