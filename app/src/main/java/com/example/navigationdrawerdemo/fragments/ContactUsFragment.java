package com.example.navigationdrawerdemo.fragments;

import static com.example.navigationdrawerdemo.util.Constants.MAPVIEW_BUNDLE_KEY;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawerdemo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ContactUsFragment extends Fragment implements OnMapReadyCallback {
    private MapView googleMapView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact_us,container,false);
        googleMapView = v.findViewById(R.id.mapView);
        TextView websiteTextView = v.findViewById(R.id.textView_centerCB);
//        websiteTextView.setClickable(true);
//        websiteTextView.setMovementMethod(LinkMovementMethod.getInstance());
//        String text = "<a href='"+Constants.CCB_WEBSITE_LINK+"'>Infosys Centre for Artificial Intelligence</a>";
//        websiteTextView.setText(Html.fromHtml(text));
        websiteTextView.setText("Infosys Centre for Artificial Intelligence");
        initGoogleMap(savedInstanceState);

        return v;
    }
    private void initGoogleMap(Bundle savedInstanceState){
        Bundle mapViewBundle = null;
        if(savedInstanceState!=null){
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        googleMapView.onCreate(mapViewBundle);
        googleMapView.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        float zoomLevel = 17.0f; //This goes up to 21

        LatLng iiitdlatlang = new LatLng(28.5450993,77.2733182);
            googleMap.addMarker(new MarkerOptions().position(new LatLng(28.5450993,77.2733182)).title("IIITD"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(iiitdlatlang, zoomLevel));
//            googleMap.getMaxZoomLevel(22);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
      //  googleMapView.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        googleMapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        googleMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        googleMapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        googleMapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        googleMapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        googleMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        googleMapView.onDestroy();
        super.onDestroyView();

    }
}
