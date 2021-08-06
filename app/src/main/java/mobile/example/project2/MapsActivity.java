package mobile.example.project2;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    MarkerOptions marker;
    LatLng centerlocation;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(5.2,103);

        markerOptions = new Vector<>();

        markerOptions.add(marker = new MarkerOptions().title("Kuala Dungun Health Center")
                .position(new LatLng(4.7614, 103.4141))
                .snippet("Open during MCO : 8am -6pm")
        );
        markerOptions.add(marker = new MarkerOptions().title("Dungun Hospital")
                .position(new LatLng(4.7519, 103.414))
                .snippet("Open during MCO : 8am -6pm")
        );

        markerOptions.add(marker = new MarkerOptions().title("Kuala Abang Health Center")
                .position(new LatLng(4.8169, 103.4204))
                .snippet("Open during MCO : 8am -6pm")
        );

        markerOptions.add(marker = new MarkerOptions().title("Paka Health Clinic")
                .position(new LatLng(4.6319, 103.4376))
                .snippet("Open during MCO : 8am -6pm")
        );

        markerOptions.add(marker = new MarkerOptions().title("Kemaman Hospital")
                .position(new LatLng(4.2319, 103.4204))
                .snippet("Open during MCO : 8am -6pm")
        );
        markerOptions.add(marker = new MarkerOptions().title("Pulau Serai Medifirst Clinic")
                .position(new LatLng(4.7856, 103.3963))
                .snippet("Open during MCO : 8am -6pm")
        );
        markerOptions.add(marker = new MarkerOptions().title("Padang Jambu Rural Clinic")
                .position(new LatLng(4.7727, 103.4083))
                .snippet("Open during MCO : 8am -6pm")
        );

        markerOptions.add(marker = new MarkerOptions().title("Nur Sejahtera Clinic")
                .position(new LatLng(4.7737, 103.4230))
                .snippet("Open during MCO : 8am -6pm")
        );

        markerOptions.add(marker = new MarkerOptions().title("Tok Kah Clinic")
                .position(new LatLng(4.7989, 103.3646))
                .snippet("Open during MCO : 8am -6pm")
        );

        markerOptions.add(marker = new MarkerOptions().title("Zahriah Clinic")
                .position(new LatLng(4.7428, 103.4167))
                .snippet("Open during MCO : 8am -6pm")
        );
        markerOptions.add(marker = new MarkerOptions().title("Kamoung Nyior Clinic")
                .position(new LatLng(4.6563, 103.4151))
                .snippet("Open during MCO : 8am -6pm")
        );

        markerOptions.add(marker = new MarkerOptions().title("Idrus SDN.BHD Clinic")
                .position(new LatLng(4.6358,  103.4375))
                .snippet("Open during MCO : 8am -6pm")
        );
        markerOptions.add(marker = new MarkerOptions().title("Syed Badaruddin Clinic")
                .position(new LatLng(4.6227, 103.4409))
                .snippet("Open during MCO : 8am -6pm")
        );

        markerOptions.add(marker = new MarkerOptions().title("Kerteh Interplant Clinic")
                .position(new LatLng(4.5893, 103.4418))
                .snippet("Open during MCO : 8am -6pm")
        );
        markerOptions.add(marker = new MarkerOptions().title("Kerteh Health Clinic")
                .position(new LatLng(4.5038, 103.4407))
                .snippet("Open during MCO : 8am -6pm")
        );

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
        // LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for(MarkerOptions mark : markerOptions) {
            mMap.addMarker(mark);
        }

        enableMyLocation();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation,8));
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this, perms, 200);
        }
    }

}