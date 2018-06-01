package com.example.sistemas.geoinstitu;

import java.util.List;

public class Datos {
    private String nombre,nombreSede,Sede,Direccion,barrio;
    private List<Double> cordenadas;

    public Datos(String nombre, String nombreSede, String sede, String direccion,String barrio, List<Double> cordenadas) {
        this.nombre = nombre;
        this.nombreSede = nombreSede;
        Sede = sede;
        Direccion = direccion;
        this.barrio = barrio;
        this.cordenadas = cordenadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getSede() {
        return Sede;
    }

    public void setSede(String sede) {
        Sede = sede;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public List<Double> getCordenadas() {
        return cordenadas;
    }

    public void setCordenadas(List<Double> cordenadas) {
        this.cordenadas = cordenadas;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
}
