package com.abdifatah.myad340;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myad340.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class TrafficMap extends AppCompatActivity
        implements
        OnMapReadyCallback
        {

    private FusedLocationProviderClient mFusedLocationClient;

    private Location mLastLocation;
    private GoogleMap mMap;

    private final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 9;
    protected boolean mAddressRequested;
    protected String mAddressOutput;


    protected TextView mLocationText;

    List<TrafficCamera> cameraData = new ArrayList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mAddressRequested = true;
        mAddressOutput = "";
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getLocations();

        String dataurl = "http://brisksoft.us/ad340/traffic_cameras_merged.json";
     }


    public void getLocations() {
            Log.d("Location", "getLocations");
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Log.d("Location", "PermissionGranted");
                mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            mLastLocation = location;
                            updateUI();
                        }
                    }
                });
            } else {
                Log.d("Location", "PermissionGranted");
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                    // logic

                } else {
                    Log.d("Location", "requestpermission");
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                }

            }
        }

/*
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int grantResults){
        Log.d("Location","onRequestPermissionsResults");
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                if(grantResults.length > 0
                        && grantResults(0) == PackageManager.PERMISSION_GRANTED){
                    updateUI();
                }else {

                }
            }
        }
    };
*/

        public void onMapReady(GoogleMap googleMap) {


        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng sydney = new LatLng(47.6205, -122.3493);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("space needle"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    };

        public void loadcameradata(String dataUrl){
            RequestQueue queue = Volley.newRequestQueue(this);
            JsonArrayRequest jsonReq = new JsonArrayRequest
                    (Request.Method.GET, dataUrl, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            Log.d("CAMERAS 1", response.toString());
                            try {
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject camera = response.getJSONObject(i);

                                    double[] coords = {camera.getDouble("ypos"), camera.getDouble("xpos")};
    /*
                                    TrafficCamera c = new TrafficCamera(
                                            camera.getString("cameralabel"),
                                            camera.getJSONObject("imageurl").getString("url"),
                                            camera.getString("ownershipcd"),
                                            coords
                                    );
                                    cameraData.add(c);
    */
                                }
                                //listAdapter.notifyDataSetChanged();
                               // if(int i=0; cameraData.size() > 1; i++)

                            } catch (JSONException e) {
                                Log.d("CAMERAS error", e.getMessage());
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error

                        }
                    });
            queue.add(jsonReq);
        };

        public void updateUI(){
        if(mLastLocation == null){
            //
        }else{
            //if(mAddressRequested){
             //   Starting onService();

            }
            LatLng myLocation = new LatLng(mLastLocation.getAltitude(), mLastLocation.getLongitude());
            mMap.setMinZoomPreference(12);
            mMap.addMarker(new MarkerOptions().position(myLocation)
                        .title(" my current location")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));

        };



        public void showmarkers(){


    };
}

