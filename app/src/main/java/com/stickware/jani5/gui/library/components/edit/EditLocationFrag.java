package com.stickware.jani5.gui.library.components.edit;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.R;
import com.stickware.jani5.databinding.ComponentsEditLocationFragBinding;
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        System.out.println("IS THIS CODE EVEN RUNNING?");
        InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
        //requireActivity().getSupportFragmentManager().popBackStack();
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa, new SLibMainFrag()).commit();
        return super.onOptionsItemSelected(item);
    }
}
