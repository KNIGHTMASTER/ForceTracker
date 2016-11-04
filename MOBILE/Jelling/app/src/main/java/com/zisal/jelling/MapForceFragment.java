package com.zisal.jelling;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tripoin.tripoin_rest.bgp.impl.BGPLocation;
import com.tripoin.tripoin_rest.dto.response.location.DTOResponseLocation;
import com.tripoin.tripoin_rest.post.IGenericPost;

import java.util.List;

import retrofit.RetrofitError;


public class MapForceFragment extends Fragment implements IGenericPost<List<DTOResponseLocation>>, OnMapReadyCallback {

    private GoogleMap googleMap;
    private List<DTOResponseLocation> dtoResponseLocations;

    /*@InjectView(R.id.mapview)*/
    public MapView mapView;
    public FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map_force, null, false);

        mapView = (MapView) view.findViewById(R.id.mapview);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AddForceFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(com.tripoin.tripoin_component.R.id.container, fragment).commit();
            }
        });

        mapView.onCreate(savedInstanceState);
        mapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                googleMap.setMyLocationEnabled(true);

                initWidget();
            }
        });

        return view;
    }

    public void initWidget() {
        new BGPLocation(this) {
            @Override
            public Context getContext() {
                return getActivity();
            }

            @Override
            public Dialog getProgressDialog() {
                return new Dialog(getActivity());
            }

        }.execute();
    }

    @Override
    public void onPostSuccess(List<DTOResponseLocation> dtoResponseLocations) {
        try {
            this.dtoResponseLocations = dtoResponseLocations;
            try {
                // For dropping a marker at a point on the Map
                if(dtoResponseLocations.size() > 1){
                    for (DTOResponseLocation dtoResponseLocation : dtoResponseLocations){
                        if (dtoResponseLocation.getLastLongitude() != null && dtoResponseLocation.getLastLatitude() != null){
                            LatLng trackerLatLong = new LatLng(Double.valueOf(dtoResponseLocation.getLastLatitude()), Double.valueOf(dtoResponseLocation.getLastLongitude()));
                            googleMap.addMarker(new MarkerOptions().position(trackerLatLong).title(dtoResponseLocation.getName()).snippet(dtoResponseLocation.getAddress()));
                        }
                    }
                    // For zooming automatically to the location of the marker
                    if(dtoResponseLocations.get(0).getLastLatitude() != null && dtoResponseLocations.get(0).getLastLongitude() != null){
                        LatLng firstTrackerLatLng = new LatLng(Double.valueOf(dtoResponseLocations.get(0).getLastLatitude()), Double.valueOf(dtoResponseLocations.get(0).getLastLongitude()));
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(firstTrackerLatLng).zoom(12).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    }
                }else{
                    Toast.makeText(getActivity(), "Tracker location is not available", Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "Error retrieving map", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPostFailure(RetrofitError retrofitError) {
        Toast.makeText(getActivity(), "Error retrieving location", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {

        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
