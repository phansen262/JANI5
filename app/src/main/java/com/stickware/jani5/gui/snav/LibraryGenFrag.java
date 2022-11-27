package com.stickware.jani5.gui.snav;

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

import com.google.android.material.tabs.TabLayout;
import com.stickware.jani5.databinding.SnavGenLibraryBaseFragBinding;
import com.stickware.jani5.gui.library.navigation.MainNavBar;
import com.stickware.jani5.gui.snav.support_library.SLibMainFrag;

public class LibraryGenFrag extends Fragment {

    protected SnavGenLibraryBaseFragBinding genBinding;
    protected TabLayout mTabs;
    protected boolean hasTabs;

    //TODO:  need to change this to an interface

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        genBinding = SnavGenLibraryBaseFragBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        addCreateView();
        return genBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        //NEEDS TO BE APPLIED FIRST!!!
        addViewCreated();

        //Listener for click selection
        genBinding.textSearchSglbf.setOnFocusChangeListener((view1, b) -> {
            setSearchSelectListener();
        });

        //Sets listener for hitting enter/search in keyboard, currently only hides keyboard, probably add another insert overridable method
        genBinding.textSearchSglbf.setOnEditorActionListener((textView, i, keyEvent) -> {

            InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        });

    }

    //Methods for handling generic group visibility
    public void setMain(){
        genBinding.setMainVisible(View.VISIBLE);
        genBinding.setListVisible(View.GONE);
        if(hasTabs) {
            mTabs.setVisibility(View.VISIBLE);
        }
        MainNavBar.setHasMenu(SnavActivity.mainNavBar, true);
        SnavActivity.hasMenuBar = true;
    }

    public void setListView(){
        genBinding.setMainVisible(View.GONE);
        genBinding.setListVisible(View.VISIBLE);
        if(hasTabs) {
            mTabs.setVisibility(View.GONE);
        }
        MainNavBar.setHasMenu(SnavActivity.mainNavBar, false);
        SnavActivity.hasMenuBar = false;
    }

    //Handle menu listener? Should only be called if in listview
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
        genBinding.textSearchSglbf.clearFocus();
        setBackListener();

        return super.onOptionsItemSelected(item);
    }

    //Methods for inserting location specific code
    protected void addViewCreated(){}
    protected void addCreateView(){}
    protected void setSearchSelectListener(){}
    protected void setBackListener(){}
}
