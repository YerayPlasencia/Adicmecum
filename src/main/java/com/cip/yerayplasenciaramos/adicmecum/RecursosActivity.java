package com.cip.yerayplasenciaramos.adicmecum;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RecursosActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        // Add markers
        //Hospital Universitario de Canarias -- 28.4554049,-16.2912038
        LatLng huc = new LatLng(28.4554049, -16.2912038);
        mMap.addMarker(new MarkerOptions()
                .position(huc)
                .title("Hospital Universitario de Canarias")
                .snippet("Tlfn: 922678000 Carr. Gral. la Cuesta, 38320 San Cristóbal de La Laguna, Santa Cruz de Tenerife"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(huc,14));

        //Hospital Universitario La Candelaria -- 28.4487923,-16.2887147
        LatLng hucande = new LatLng(28.4487923, -16.2887147);
        mMap.addMarker(new MarkerOptions()
                .position(hucande)
                .title("Hospital Universitario Nuestra Señora de Candelaria")
                .snippet("Tlfn: 922602000 Plaza el Rosario, 115, 38010 Santa Cruz de Tenerife"));

        //Centro Médico Laguna Salud -- 28.4877105,-16.3385654
        LatLng cslaguna = new LatLng(28.4877105, -16.3385654);
        mMap.addMarker(new MarkerOptions()
                .position(cslaguna)
                .title("Centro Médico Laguna Salud")
                .snippet("Tlfn: 922632185 Calle 6 de Diciembre, 20, Local 2, 38203 San Cristóbal de La Laguna, Santa Cruz de Tenerife"));

        //Centro de Salud Las Mercedes -- 28.4877105,-16.3385654
        LatLng csmercedes = new LatLng(28.4877105, -16.3385654);
        mMap.addMarker(new MarkerOptions()
                .position(csmercedes)
                .title("Centro de Salud Las Mercedes")
                .snippet("Tlfn: 922174271 38201 San Cristóbal de La Laguna, Santa Cruz de Tenerife"));

        //Centro Salud Finca España -- 28.4737618,-16.3073872
        LatLng csfincaes = new LatLng(28.4737618, -16.3073872);
        mMap.addMarker(new MarkerOptions()
                .position(csfincaes)
                .title("Centro Salud Finca España")
                .snippet("Tlfn: 922478201 Av. de los Menceyes, 153, 38201 San Cristóbal de La Laguna, Santa Cruz de Tenerife"));

        //Centro de Salud La Cuesta -- 28.4682006,-16.2928616
        LatLng cscuesta = new LatLng(28.4682006, -16.2928616);
        mMap.addMarker(new MarkerOptions()
                .position(cscuesta)
                .title("Centro de Salud La Cuesta")
                .snippet("Tlfn: 922924101 Calle Rector Jose Escobedo y Glez Alberu, 6, 38320 San Cristóbal de La Laguna, Santa Cruz de Tenerife"));

        //Centro de Salud Barrio de la Salud -- 28.4608278,-16.2794866
        LatLng csbsalud = new LatLng(28.4608278, -16.2794866);
        mMap.addMarker(new MarkerOptions()
                .position(csbsalud)
                .title("Centro de Salud Los Gladiolos")
                .snippet("Tlfn: 922474000 Av. de Venezuela, 6, 38007 Santa Cruz de Tenerife"));

        //Centro de Salud Los Gladiolos -- 28.4541742,-16.2861513
        LatLng csglad = new LatLng(28.4541742, -16.2861513);
        mMap.addMarker(new MarkerOptions()
                .position(csglad)
                .title("Centro de Salud Los Gladiolos")
                .snippet("Tlfn: 922236690 Calle Ganivet, 5, 38007 Santa Cruz de Tenerife"));

        //Centro de Salud Ofra Delicias -- 28.4524134,-16.2870841
        LatLng csofrad = new LatLng(28.4524134, -16.2870841);
        mMap.addMarker(new MarkerOptions()
                .position(csofrad)
                .title("Centro Salud Ofra Delicias")
                .snippet("Tlfn: 922675100 Av. Principes de España, 7A, 38010 Santa Cruz de Tenerife"));

        //Asociación de Cooperación Juvenil San Miguel
        LatLng acsanmiguel = new LatLng(28.4524134, -16.2870841);
        mMap.addMarker(new MarkerOptions()
                .position(acsanmiguel)
                .title("San Miguel Adicciones")
                .snippet("Tlfn: 922288812 Calle Horacio Nelson, 32 C.P: 38006 Santa Cruz de Tenerife"));

        //Centro de Salud Duggi Centro -- 28.4620994,-16.2549056
        LatLng csduggi = new LatLng(28.4620994, -16.2549056);
        mMap.addMarker(new MarkerOptions()
                .position(csduggi)
                .title("Centro de Salud Duggi Centro")
                .snippet("Tlfn: 922951613 Calle de Carmen Monteverde, 45, 38003 Santa Cruz de Tenerife"));

        //C.S. Toscal Centro / CS Ruíz de Padrón -- 28.4620994,-16.2549056
        LatLng cstoscal = new LatLng(28.4620994, -16.2549056);
        mMap.addMarker(new MarkerOptions()
                .position(cstoscal)
                .title("C.S. Toscal Centro / CS Ruíz de Padrón")
                .snippet("Tlfn: 922478340 Calle Ruíz de Padrón, 6, 38002 Santa Cruz de Tenerife"));
    }
}