package com.stickware.jani5.gui.library.components.edit;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.R;
import com.stickware.jani5.databinding.ComponentsEditLocationFragBinding;
import com.stickware.jani5.gui.library.navigation.MainNavBar;
import com.stickware.jani5.logic.app_objects.JLocation;
import com.stickware.jani5.servers.LocationServer;

public class EditLocationFrag extends Fragment {

    public static JLocation editLocation;

    protected ComponentsEditLocationFragBinding mBinding;

    private static MainNavBar mBar;

    public static Fragment newInstance(MainNavBar bar){

        mBar = bar;
        return new EditLocationFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mBinding = ComponentsEditLocationFragBinding.inflate(inflater, container, false);

        //Init Location
        editLocation = LocationServer.activeJLocation;

        //Options
        setHasOptionsMenu(true);
        MainNavBar.setHasMenu(mBar, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Location editL = editLocation.getMLocation();
        if(editL != null){
            String s = "Lat: " + editL.getLatitude() + "  Long: " + editL.getLongitude();
            mBinding.displayLocationCelf.setText(s);
            mBinding.addLocationButtonCelf.setText("Reset Location");
        } else {
            mBinding.displayLocationCelf.setText("No Location Selected");
            mBinding.addLocationButtonCelf.setText("Add Location");
        }

        //Add Listener for Add Location Button
        mBinding.addLocationButtonCelf.setOnClickListener(view1 -> {
            setHasOptionsMenu(false);
            //Need to address how to handle this from other locations, probably need to pass R.id number as parameter
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa, new EditLocationMapFrag()).addToBackStack("").commit();
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        requireActivity().getMenuInflater().inflate(R.menu.save, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        //Back Button
        if(item.getItemId() == android.R.id.home) {
            //Hide keyboard
            InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
            //Navigates back via backstack
            requireActivity().getSupportFragmentManager().popBackStack();
            return true;
        }
        //Save Button
        else if(item.getItemId() == R.id.save_basic_menus){
            editLocation.setmName(mBinding.nameEdittextCelf.getText().toString());
            editLocation.setmDescription(mBinding.descriptionEdittextCelf.getText().toString());
            LocationServer.activeJLocation = editLocation;
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
