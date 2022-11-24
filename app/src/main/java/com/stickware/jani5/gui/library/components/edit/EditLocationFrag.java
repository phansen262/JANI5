package com.stickware.jani5.gui.library.components.edit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.R;
import com.stickware.jani5.databinding.ComponentsEditLocationFragBinding;
import com.stickware.jani5.gui.library.navigation.MainNavBar;
import com.stickware.jani5.logic.app_objects.JLocation;
import com.stickware.jani5.servers.LocationServer;

import java.io.IOException;

public class EditLocationFrag extends Fragment {

    public static JLocation editLocation;

    protected ComponentsEditLocationFragBinding mBinding;

    private static MainNavBar mBar;

    public EditLocationFrag(MainNavBar bar){
        mBar = bar;
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

        //Add listener for imageView
        mBinding.imageCelf.setOnClickListener(view1 -> {
            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);

            launchSomeActivity.launch(i);
        });

        //Add Listener for Add Location Button
        mBinding.addLocationButtonCelf.setOnClickListener(view1 -> {
            setHasOptionsMenu(false);
            //Need to address how to handle this from other locations, probably need to pass R.id number as parameter
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa, new EditLocationMapFrag()).addToBackStack("").commit();
        });
    }

    public ActivityResultLauncher<Intent> launchSomeActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

        if(result.getResultCode() == Activity.RESULT_OK){
            Intent data = result.getData();
            //DO OPERATION HERE???
            if(data != null){
                Uri selectedImageUri = data.getData();
                Bitmap selectedImageBitmap = null;
                try {
                    selectedImageBitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), selectedImageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mBinding.imageCelf.setImageBitmap(selectedImageBitmap);
            }
        }
    });

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
