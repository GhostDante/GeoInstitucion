package com.example.sistemas.geoinstitu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Institu {

    @SerializedName("barrio")
    @Expose
    private String barrio;
    @SerializedName("codigo_dane")
    @Expose
    private String codigoDane;
    @SerializedName("coordenadas_e_e_validadas")
    @Expose
    private CoordenadasEEValidadas coordenadasEEValidadas;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("nombre_establecimiento_educativo")
    @Expose
    private String nombreEstablecimientoEducativo;
    @SerializedName("nomnbre_de_la_sede_educativa")
    @Expose
    private String nomnbreDeLaSedeEducativa;
    @SerializedName("sede")
    @Expose
    private String sede;
    @SerializedName("ubicacion_en_dos_columnas")
    @Expose
    private UbicacionEnDosColumnas ubicacionEnDosColumnas;
    @SerializedName("zona")
    @Expose
    private String zona;

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCodigoDane() {
        return codigoDane;
    }

    public void setCodigoDane(String codigoDane) {
        this.codigoDane = codigoDane;
    }

    public CoordenadasEEValidadas getCoordenadasEEValidadas() {
        return coordenadasEEValidadas;
    }

    public void setCoordenadasEEValidadas(CoordenadasEEValidadas coordenadasEEValidadas) {
        this.coordenadasEEValidadas = coordenadasEEValidadas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreEstablecimientoEducativo() {
        return nombreEstablecimientoEducativo;
    }

    public void setNombreEstablecimientoEducativo(String nombreEstablecimientoEducativo) {
        this.nombreEstablecimientoEducativo = nombreEstablecimientoEducativo;
    }

    public String getNomnbreDeLaSedeEducativa() {
        return nomnbreDeLaSedeEducativa;
    }

    public void setNomnbreDeLaSedeEducativa(String nomnbreDeLaSedeEducativa) {
        this.nomnbreDeLaSedeEducativa = nomnbreDeLaSedeEducativa;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public UbicacionEnDosColumnas getUbicacionEnDosColumnas() {
        return ubicacionEnDosColumnas;
    }

    public void setUbicacionEnDosColumnas(UbicacionEnDosColumnas ubicacionEnDosColumnas) {
        this.ubicacionEnDosColumnas = ubicacionEnDosColumnas;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
