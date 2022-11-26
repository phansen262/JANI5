package com.stickware.jani5.gui.library.components.edit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.stickware.jani5.R;
import com.stickware.jani5.databinding.ComponentsMapsViewBinding;
import com.stickware.jani5.logic.app_objects.jlocation.JLocationServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EditLocationMapFrag extends Fragment implements GoogleMap.OnMyLocationButtonClickListener {

    private ComponentsMapsViewBinding mBinding;
    private GoogleMap mMap;
    private Location mSelectedLocation;

    //TODO:  need to make map select and map place select work
    @SuppressLint("MissingPermission")
    private OnMapReadyCallback callback = googleMap -> {

        mMap = googleMap;
        //Setup map
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        LatLng latLng = null;
        //Get Starting Location
        if(EditLocationFrag.editLocation.getMLocation() == null) {
            LocationManager l = (LocationManager) requireActivity().getSystemService(Context.LOCATION_SERVICE);
            mSelectedLocation = l.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            latLng = new LatLng(mSelectedLocation.getLatitude(), mSelectedLocation.getLongitude());
        } else {
            latLng = new LatLng(EditLocationFrag.editLocation.getMLocation().getLatitude(),
                    EditLocationFrag.editLocation.getMLocation().getLongitude());
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        mMap.addMarker(new MarkerOptions().position(latLng).title("Location"));
        //Move Location to server
        EditLocationFrag.editLocation.setMLocation(mSelectedLocation);
    };

    @Override
    public boolean onMyLocationButtonClick() {
        //Just need default behavior
        return false;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = ComponentsMapsViewBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

        mBinding.selectButtonCmv.setOnClickListener(View -> {

            EditLocationFrag.editLocation.setMLocation(mSelectedLocation);
            //Navigates back via backstack
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        //TODO: Check to see if this could be used for library search bar
        mBinding.searchMapCmv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=Point 90 Mall, Cairo Governorate"));
                //startActivity(intent);

                String loc = mBinding.searchMapCmv.getQuery().toString();
                List<Address> addressList = new ArrayList<>();

                if(loc != null || loc.equals("")){
                    //Lookup address
                    Geocoder geocoder = new Geocoder(requireContext());
                    try {
                        addressList = geocoder.getFromLocationName(loc, 1);

                    } catch (IOException e) {
                        System.err.println("JUST DID STACKTRACE");
                        e.printStackTrace();

                    }

                    if(addressList.size() != 0) {
                        //Move to found address
                        Address address = addressList.get(0);
                        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                        mMap.clear();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(loc));
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                        //Update current location
                        mSelectedLocation = new Location("");
                        mSelectedLocation.setLatitude(latLng.latitude);
                        mSelectedLocation.setLongitude(latLng.longitude);
                    }
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        //Hide keyboard
        InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
        //Reset location of editLocation (can be setting to null if server jLocation doesn't have location)
        EditLocationFrag.editLocation.setMLocation(JLocationServer.activeJLocation.getMLocation());
        //Navigates back via backstack
        requireActivity().getSupportFragmentManager().popBackStack();
        return super.onOptionsItemSelected(item);
    }


}
