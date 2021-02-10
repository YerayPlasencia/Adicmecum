package com.cip.yerayplasenciaramos.adicmecum.model;

public class Farmaco {

    public String nombre;
    public String efectosSecundarios;
    public String indicaciones;
    public String interacciones;
    public String posologia;

    public Farmaco(){
    }

    public Farmaco( String nombre, String efectosSecundarios, String indicaciones, String interacciones, String posologia) {
        this.nombre = nombre;
        this.efectosSecundarios = efectosSecundarios;
        this.indicaciones = indicaciones;
        this.interacciones = interacciones;
        this.posologia = posologia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEfectosSecundarios() {
        return efectosSecundarios;
    }

    public void setEfectosSecundarios(String efectosSecundarios) {
        this.efectosSecundarios = efectosSecundarios;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getInteracciones() {
        return interacciones;
    }

    public void setInteracciones(String interacciones) {
        this.interacciones = interacciones;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    @Override
    public String toString() {
        return nombre;
    }
}