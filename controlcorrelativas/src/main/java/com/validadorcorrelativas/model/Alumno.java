package com.validadorcorrelativas.model;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private String Nombre;
    private String Apellido;

    private List<Materia> aprobadas = new ArrayList<Materia>();

    public Alumno() {
        super();
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setMateriaAprobada(Materia materia) {
        if (!aprobadas.stream().anyMatch(x -> x.getNombre() == materia.getNombre()) && materia.getAprobada())
            aprobadas.add(materia);
    }

    public List<Materia> getMateriasAprobadas() {
        return aprobadas;
    }

}
