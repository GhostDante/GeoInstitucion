package com.example.sistemas.geoinstitu;

import com.example.sistemas.geoinstitu.contru.Construccion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Union {

    @GET("vv6c-id8g.json")
    Call<ArrayList<Institu>> obtenerLista();

    @GET("rzdd-pqtk.json")
    Call<ArrayList<Construccion>> obtenerListaConstrucciones();
}
