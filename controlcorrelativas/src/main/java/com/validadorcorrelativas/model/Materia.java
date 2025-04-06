package com.validadorcorrelativas.model;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private String Nombre = "";
    private boolean Aprobada = false;
    private List<Materia> correlativas = new ArrayList<Materia>();

    public Materia() {
        super();
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public List<Materia> getCorrelativas() {
        return this.correlativas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setAprobada(boolean bool) {
        this.Aprobada = bool;
    }

    public boolean getAprobada() {
        return Aprobada;
    }
}
