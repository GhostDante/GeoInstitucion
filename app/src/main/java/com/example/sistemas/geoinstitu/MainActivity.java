package com.example.sistemas.geoinstitu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.sistemas.geoinstitu.contru.AdaptadorConstruccion;
import com.example.sistemas.geoinstitu.contru.Construccion;
import com.example.sistemas.geoinstitu.contru.Edificio;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    private Retrofit retrofit;
    private ArrayList<Datos> datos;
    private ArrayList<Edificio> edificios;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle(null);
        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this.getApplicationContext());
        rv.setLayoutManager(llm);
        datos = new ArrayList<Datos>();
        edificios = new ArrayList<Edificio>();
        retrofit = new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();
        obtenerDatos();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_instituciones) {
            rv.removeAllViews();
            AdaptadorInstituciones x = new AdaptadorInstituciones(datos);
            rv.setAdapter(x);
            // Handle the camera action
        } else if (id == R.id.nav_construcciones) {
            rv.removeAllViews();
             AdaptadorConstruccion x = new AdaptadorConstruccion(edificios);
             rv.setAdapter(x);
        } else if (id == R.id.nav_Acercade) {
            acerca();

        }  else if (id == R.id.nav_send) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void obtenerDatos() {
        Union service = retrofit.create(Union.class);
        Call<ArrayList<Institu>> arrayListCall = service.obtenerLista();
        arrayListCall.enqueue(new Callback<ArrayList<Institu>>() {
            @Override
            public void onResponse(Call<ArrayList<Institu>> call, Response<ArrayList<Institu>> response) {
                if(response.isSuccessful()){
                    ArrayList<Institu> respuesta = response.body();
                    for (int i=0;i<respuesta.size();i++){
                        Institu miInstitu = respuesta.get(i);
                        Datos nuevo = new Datos(miInstitu.getNombreEstablecimientoEducativo(),miInstitu.getNomnbreDeLaSedeEducativa(),miInstitu.getSede(),miInstitu.getDireccion(),miInstitu.getBarrio(),miInstitu.getUbicacionEnDosColumnas().getCoordinates());
                        datos.add(nuevo);

                    }
                    AdaptadorInstituciones x = new AdaptadorInstituciones(datos);
                    rv.setAdapter(x);


                }else{
                    Log.e("aca", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Institu>> call, Throwable t) {
                Log.e("aqui", " onFailure: " + t.getMessage());
            }
        });


        Call<ArrayList<Construccion>> arrayListCallConstruccion = service.obtenerListaConstrucciones();
        arrayListCallConstruccion.enqueue(new Callback<ArrayList<Construccion>>() {
            @Override
            public void onResponse(Call<ArrayList<Construccion>> call, Response<ArrayList<Construccion>> response) {
                if(response.isSuccessful()){
                    ArrayList<Construccion> respuesta = response.body();
                    for (int i=0;i<respuesta.size();i++){
                        Construccion miConstruccion = respuesta.get(i);
                        Edificio nuevo = new Edificio(miConstruccion.getEstablecimientoEducativo(),miConstruccion.getEstado(),miConstruccion.getIntervenciNRealizada(),miConstruccion.getInversiN(),miConstruccion.getLatitud().getCoordinates());
                        edificios.add(nuevo);

                    }
                }else{
                    Log.e("aca", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Construccion>> call, Throwable t) {
                Log.e("aqui", " onFailure: " + t.getMessage());
            }
        });

    }

    public void actualizarListaPorContrucciones(Double uno, Double dos) {
        ArrayList<Edificio> temp = new ArrayList<Edificio>();
        for (int i = 0; i < edificios.size(); i++) {
            Edificio miEdificio = edificios.get(i);
            Log.e("sdas",uno+" "+dos);
            Log.i("sdas",miEdificio.getCordenadas().get(0)+" "+miEdificio.getCordenadas().get(1));
            if(miEdificio.getCordenadas().get(0).compareTo(uno)==0 && miEdificio.getCordenadas().get(1).compareTo(dos)==0){
                temp.add(miEdificio);
            }
        }
        rv.removeAllViews();
        AdaptadorConstruccion x = new AdaptadorConstruccion(temp);
        rv.setAdapter(x);
    }

    public void acerca() {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }

}
