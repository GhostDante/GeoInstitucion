package com.example.sistemas.geoinstitu;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView tv1,tv2,tv3;
    public double lat = 0.0;
    public double lon = 0.0;
    private String nombre,sede,direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle bundle = getIntent().getExtras();
        lat=bundle.getDouble("v");
        lon=bundle.getDouble("v1");
        Log.d("s",lat+"");
        Log.d("d",lon+"");
        tv1=(TextView) findViewById(R.id.tvm1);
        tv2=(TextView) findViewById(R.id.tvm2);
        tv3=(TextView) findViewById(R.id.tvm3);
        nombre = bundle.getString("nombre");
        sede = bundle.getString("sede");
        direccion = bundle.getString("direccion");

        tv1.setText(nombre);
        tv2.setText(sede);
        tv3.setText(direccion);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lon, lat);
        mMap.addMarker(new MarkerOptions().position(sydney).title(nombre));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.setMapType(googleMap.MAP_TYPE_NORMAL);
    }
}
