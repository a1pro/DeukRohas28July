package com.deukrohas.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deukrohas.R;
import com.deukrohas.activities.AddDeliveryInfo;
import com.deukrohas.activities.ChoosePackageActivty;
import com.deukrohas.activities.YourCurrentLocaton;
import com.deukrohas.location.GPSTracker;
import com.deukrohas.location.LocationTrack;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements LocationListener {

    private GoogleMap mMap;
    MapView mMapView;
    private GoogleMap googleMap;
    private LinearLayout choose_package;
    RelativeLayout appBar;
    GPSTracker gpsTracker;
    Location location;
    private LinearLayout off_location;
    private Button enable_location;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    LocationTrack locationTrack;
    double latitude, longtitude;
    Geocoder geocoder;
    TextView address123;
    List<Address> addresses;
    DialogInterface dialogInterfaceAll;
    public LinearLayout layoutBottomSheet;
    private CardView packageone, packagetwo, packagethree;
    public static BottomSheetBehavior sheetBehavior;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mMapView = view.findViewById(R.id.mapView);
        address123 = view.findViewById(R.id.addressuper);
        enable_location = view.findViewById(R.id.enable_location);
        off_location = view.findViewById(R.id.off_location);
        layoutBottomSheet = view.findViewById(R.id.bottom_sheet);
        packageone = view.findViewById(R.id.packageone);
        packagetwo = view.findViewById(R.id.packagetwo);
        packagethree = view.findViewById(R.id.packagethree);
        mMapView.onCreate(savedInstanceState);
        if (checkLocationPermission()) {
            statusCheck();
            gpsTracker = new GPSTracker(getContext());
            getLocation();
            if (location != null) {
                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap mMap) {
                        googleMap = mMap;
                        // For showing a move to my location button
                        //  googleMap.setMyLocationEnabled(true);

                        // For dropping a marker at a point on the Map
                        LatLng sydney = new LatLng(latitude, longtitude);
                        googleMap.addMarker(new MarkerOptions().position(sydney).title("Your Location").snippet(""));

                        // For zooming automatically to the location of the marker
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    }
                });
            }
        }

        if (statusCheck1()) {
            mMapView.setVisibility(View.VISIBLE);
            off_location.setVisibility(View.GONE);
        } else {
            off_location.setVisibility(View.VISIBLE);
            mMapView.setVisibility(View.GONE);
        }
        enable_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkLocationPermission()) {
                    statusCheck();
                }
            }
        });


        choose_package = view.findViewById(R.id.choose_package);
        appBar = view.findViewById(R.id.reltivejkl);
        appBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YourCurrentLocaton.class);
                startActivity(intent);
            }
        });
        packageone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddDeliveryInfo.class);
                intent.putExtra("location", address123.getText().toString());
                intent.putExtra("latitude", "" + latitude);
                intent.putExtra("longtitude", "" + longtitude);
                startActivity(intent);
            }
        });
        packagetwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddDeliveryInfo.class);
                intent.putExtra("location", address123.getText().toString());
                intent.putExtra("latitude", "" + latitude);
                intent.putExtra("longtitude", "" + longtitude);
                startActivity(intent);
            }
        });
        packagethree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddDeliveryInfo.class);
                intent.putExtra("location", address123.getText().toString());
                intent.putExtra("latitude", "" + latitude);
                intent.putExtra("longtitude", "" + longtitude);
                startActivity(intent);
            }
        });
        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }


        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
//                        CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
//                                CoordinatorLayout.LayoutParams.WRAP_CONTENT);
//                        params.setMargins(0, 250, 0, 0);
//                        layoutBottomSheet.setLayoutParams(params);
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        break;
                    }
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

//        if (address123.getText().toString()!=null && !address123.getText().toString().isEmpty()){
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        //  }
        choose_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet();
            }
        });

        return view;
    }

    private void toggleBottomSheet() {

        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }


    public void getLocation() {

        locationTrack = new LocationTrack(getActivity());
        if (locationTrack.canGetLocation()) {


            longtitude = locationTrack.getLongitude();
            latitude = locationTrack.getLatitude();

            mMapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap mMap) {
                    googleMap = mMap;
                    // For showing a move to my location button
                    //  googleMap.setMyLocationEnabled(true);

                    // For dropping a marker at a point on the Map
                    LatLng sydney = new LatLng(latitude, longtitude);
                    googleMap.addMarker(new MarkerOptions().position(sydney).title("Your Location").snippet(""));

                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            });

            // Toast.makeText(getActivity().getApplicationContext(), "Longitude:" + Double.toString(longtitude) + "\nLatitude:" + Double.toString(latitude), Toast.LENGTH_SHORT).show();

            geocoder = new Geocoder(getActivity(), Locale.getDefault());

            try {
                addresses = geocoder.getFromLocation(latitude, longtitude, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (addresses != null) {
                if (addresses.size() != 0) {
                    String address = addresses.get(0).getAddressLine(0);
                    address123.setText(address);
                }
            }
        } else {

            locationTrack.showSettingsAlert();
        }
    }

    public void statusCheck() {
        final LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        }
    }

    public boolean statusCheck1() {
        final LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //buildAlertMessageNoGps();
            return false;
        }
        return true;
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(getContext())
                        .setTitle("Location Permission")
                        .setMessage("Please allow location permission")
                        .setPositiveButton("Enable", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterfaceAll = dialogInterface;
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(getActivity(),
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onResume() {
        super.onResume();

        if (dialogInterfaceAll != null) {
            dialogInterfaceAll.dismiss();
        }
        if (checkLocationPermission()) {
            if (statusCheck1()) {
                mMapView.setVisibility(View.VISIBLE);
                off_location.setVisibility(View.GONE);
                getLocation();
            } else {
                off_location.setVisibility(View.VISIBLE);
                mMapView.setVisibility(View.GONE);
            }
            // statusCheck();
            gpsTracker = new GPSTracker(getContext());
            location = gpsTracker.getLocation();
            if (location != null) {
                mMapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap mMap) {
                        googleMap = mMap;
                        // For showing a move to my location button
                        //  googleMap.setMyLocationEnabled(true);

                        // For dropping a marker at a point on the Map
                        LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
                        googleMap.addMarker(new MarkerOptions().position(sydney).title("Your Location").snippet(""));

                        // For zooming automatically to the location of the marker
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    }
                });
            }
        }

    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialogInterfaceAll = dialog;
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialogInterfaceAll = dialog;
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(getContext(),
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        off_location.setVisibility(View.GONE);
                        mMapView.setVisibility(View.VISIBLE);

                        //Request location updates:
                        // locationManager.requestLocationUpdates(provider, 400, 1, this);
                    }

                } else {
                    off_location.setVisibility(View.VISIBLE);
                    mMapView.setVisibility(View.GONE);
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        off_location.setVisibility(View.GONE);
        mMapView.setVisibility(View.VISIBLE);
        if (location != null) {
            mMapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap mMap) {
                    googleMap = mMap;
                    // For showing a move to my location button
                    //  googleMap.setMyLocationEnabled(true);

                    // For dropping a marker at a point on the Map
                    LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
                    googleMap.addMarker(new MarkerOptions().position(sydney).title("Your Location").snippet(""));

                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            });
        }

    }

    @Override
    public void onProviderDisabled(String provider) {
        off_location.setVisibility(View.VISIBLE);
        mMapView.setVisibility(View.GONE);
    }
}

