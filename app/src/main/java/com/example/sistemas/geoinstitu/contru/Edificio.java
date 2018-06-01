package com.example.sistemas.geoinstitu.contru;

import java.util.List;

public class Edificio {

    private String nombreEstablecimiento,estado,intervencion,inversion;
    private List<Double> cordenadas;

    public Edificio(String nombreEstablecimiento, String estado, String intervension, String inversion, List<Double> cordenadas) {
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.estado = estado;
        this.intervencion = intervension;
        this.inversion = inversion;
        this.cordenadas = cordenadas;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(String intervencion) {
        this.intervencion = intervencion;
    }

    public String getInvercion() {
        return inversion;
    }

    public void setInvercion(String invercion) {
        this.inversion = invercion;
    }

    public List<Double> getCordenadas() {
        return cordenadas;
    }

    public void setCordenadas(List<Double> cordenadas) {
        this.cordenadas = cordenadas;
    }
}
