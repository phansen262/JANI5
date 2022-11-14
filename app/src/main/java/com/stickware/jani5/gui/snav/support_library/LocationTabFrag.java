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
            System.out.println("LibGenFrag 45: " + SLibMainFrag.mFragState.toString());
            setMain();
        } else {
            setListView();
        }

        //Setup new buttons
        genBinding.newButtonSglbf.setOnClickListener(view -> {
            setHasOptionsMenu(false);
            SnavActivity.hasMenuBar = false;
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa,
                    EditLocationFrag.newInstance(SnavActivity.mainNavBar)).commit();
        });
        genBinding.newFloatingButtonSglbf.setOnClickListener(view -> {
            setHasOptionsMenu(false);
            SnavActivity.hasMenuBar = false;
            InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa,
                    EditLocationFrag.newInstance(SnavActivity.mainNavBar)).commit();
        });
    }

    @Override
    protected void setSearchSelectListener(){

        if(SLibMainFrag.mFragState.getHasMenu()) {
            System.out.println("WHY THE FUCK LOCATIONTAB 43:  " + SLibMainFrag.mFragState.toString());
            SLibMainFrag.mFragState = SLibMainFrag.FragState.LOCATIONLIST;
            System.out.println("LOCATIONTAB 53:  " + SLibMainFrag.mFragState.toString());
            setListView();
        }
    }

    @Override
    protected void setBackListener(){

        System.out.println("LOCATIONTAB 52:  " + SLibMainFrag.mFragState.toString());
        SLibMainFrag.mFragState = SLibMainFrag.FragState.LOCATIONMAIN;
        System.out.println("LOCATIONTAB 54:  " + SLibMainFrag.mFragState.toString());
        setMain();
    }
}
