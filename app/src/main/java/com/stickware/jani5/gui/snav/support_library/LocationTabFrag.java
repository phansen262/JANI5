package com.stickware.jani5.gui.snav.support_library;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import com.stickware.jani5.R;
import com.stickware.jani5.gui.library.components.edit.EditLocationFrag;
import com.stickware.jani5.gui.snav.LibraryGenFrag;
import com.stickware.jani5.gui.snav.SnavActivity;

public class LocationTabFrag extends LibraryGenFrag {

    @Override
    protected void addCreateView() {
        super.addCreateView();

    }

    @Override
    protected void addViewCreated(){

        //Set Initial View
        hasTabs = true;
        mTabs = requireActivity().findViewById(R.id.tabs_ssmf);
        if(SLibMainFrag.mFragState.getHasMenu()) {
            setMain();
        } else {
            setListView();
        }

        //Setup new buttons
        genBinding.newButtonSglbf.setOnClickListener(view -> {
            //Very important to set hasOptionsMenu to false, otherwise the back code will still run from this frag
            setHasOptionsMenu(false);
            SnavActivity.hasMenuBar = false;
            //Move to next frag
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa,
                    new EditLocationFrag(SnavActivity.mainNavBar)).addToBackStack("").commit();
        });
        genBinding.newFloatingButtonSglbf.setOnClickListener(view -> {
            //Very important to set hasOptionsMenu to false, otherwise the back code will still run from this frag
            setHasOptionsMenu(false);
            SnavActivity.hasMenuBar = false;
            //Hide the keyboard if needed
            InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
            //Move to next frag
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa,
                    new EditLocationFrag(SnavActivity.mainNavBar)).addToBackStack("").commit();
        });
    }

    @Override
    protected void setSearchSelectListener(){

        //Called when search bar is selected
        if(SLibMainFrag.mFragState.getHasMenu()) {
            SLibMainFrag.mFragState = SLibMainFrag.FragState.LOCATIONLIST;
            setListView();
        }
    }

    @Override
    protected void setBackListener(){

        //Called when back is selected
        SLibMainFrag.mFragState = SLibMainFrag.FragState.LOCATIONMAIN;
        setMain();
    }
}
