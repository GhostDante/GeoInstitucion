package com.example.sistemas.geoinstitu.contru;

import com.example.sistemas.geoinstitu.CoordenadasEEValidadas;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Construccion {

    @SerializedName("comuna_corregimiento")
    @Expose
    private String comunaCorregimiento;
    @SerializedName("coordenadas_e_e_validadas")
    @Expose
    private CoordenadasEEValidadas coordenadasEEValidadas;
    @SerializedName("establecimiento_educativo")
    @Expose
    private String establecimientoEducativo;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("intervenci_n_realizada")
    @Expose
    private String intervenciNRealizada;
    @SerializedName("inversi_n")
    @Expose
    private String inversiN;
    @SerializedName("latitud")
    @Expose
    private Latitud latitud;
    @SerializedName("nueva_construcci_n_mejoramiento")
    @Expose
    private String nuevaConstrucciNMejoramiento;
    @SerializedName("sede")
    @Expose
    private String sede;
    @SerializedName("vigencia")
    @Expose
    private String vigencia;

    public String getComunaCorregimiento() {
        return comunaCorregimiento;
    }

    public void setComunaCorregimiento(String comunaCorregimiento) {
        this.comunaCorregimiento = comunaCorregimiento;
    }

    public CoordenadasEEValidadas getCoordenadasEEValidadas() {
        return coordenadasEEValidadas;
    }

    public void setCoordenadasEEValidadas(CoordenadasEEValidadas coordenadasEEValidadas) {
        this.coordenadasEEValidadas = coordenadasEEValidadas;
    }

    public String getEstablecimientoEducativo() {
        return establecimientoEducativo;
    }

    public void setEstablecimientoEducativo(String establecimientoEducativo) {
        this.establecimientoEducativo = establecimientoEducativo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIntervenciNRealizada() {
        return intervenciNRealizada;
    }

    public void setIntervenciNRealizada(String intervenciNRealizada) {
        this.intervenciNRealizada = intervenciNRealizada;
    }

    public String getInversiN() {
        return inversiN;
    }

    public void setInversiN(String inversiN) {
        this.inversiN = inversiN;
    }

    public Latitud getLatitud() {
        return latitud;
    }

    public void setLatitud(Latitud latitud) {
        this.latitud = latitud;
    }

    public String getNuevaConstrucciNMejoramiento() {
        return nuevaConstrucciNMejoramiento;
    }

    public void setNuevaConstrucciNMejoramiento(String nuevaConstrucciNMejoramiento) {
        this.nuevaConstrucciNMejoramiento = nuevaConstrucciNMejoramiento;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

}
