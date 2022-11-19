package com.stickware.jani5.gui.library.components.edit;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.R;
import com.stickware.jani5.databinding.ComponentsEditLocationFragBinding;
import com.stickware.jani5.gui.library.components.maps.MapFrag;
import com.stickware.jani5.gui.library.navigation.MainNavBar;
import com.stickware.jani5.gui.snav.support_library.LocationTabFrag;
import com.stickware.jani5.gui.snav.support_library.SLibMainFrag;

public class EditLocationFrag extends Fragment {

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
        setHasOptionsMenu(true);
        MainNavBar.setHasMenu(mBar, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.addLocationButtonCelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setHasOptionsMenu(false);
                //Need to address how to handle this from other locations, probably need to pass R.id number as parameter
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa, new MapFrag()).addToBackStack("").commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa, new MapsFragment()).addToBackStack("").commit();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        //Hide keyboard
        InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
        //Navigates back via backstack
        requireActivity().getSupportFragmentManager().popBackStack();
        return super.onOptionsItemSelected(item);
    }
}
