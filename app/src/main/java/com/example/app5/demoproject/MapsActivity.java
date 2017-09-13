package com.example.app5.demoproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        LatLng Kmutnb = new LatLng(13.817353, 100.5134383);
        LatLng Bangsu = new LatLng(13.8046794,100.5307246);
        LatLng KasamRad = new LatLng(13.831756,100.5364663);

        mMap = googleMap;
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        //marker
        mMap.addMarker(new MarkerOptions()
                .position(Kmutnb)
                .title("KMUTNB")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker0))
        );
        mMap.addMarker(new MarkerOptions()
                .position(Bangsu).title("Bangsu")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker0))
        );
        mMap.addMarker(new MarkerOptions()
                .position(KasamRad).title("โรงพยาบาลเกษมราษฎร์")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker0))
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kmutnb));

        mMap.setTrafficEnabled(false);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION},0);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }else {
            mMap.setMyLocationEnabled(true);
        }

     }

     @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
         if (requestCode==0){
             if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                     mMap.setMyLocationEnabled(true);
             }
         }

     }



/*
     public void onClick(){                     //Button Login
     Button btn1 = (Button)findViewById(R.id.button2);
     Intent intent = new Intent(MapsActivity.this,login.class);
     startActivity(intent);
 }
*/

    //Search
    /*public void onSearch(View view)
    {
        EditText location_tf = (EditText)findViewById(R.id.btnSearch);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;
        if(location != null || !location.equals(""))
        {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location , 1);


            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude() , address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        }
    }
*/
}
