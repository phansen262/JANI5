package com.stickware.jani5.gui.library.components.edit;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.ComponentsEditEquipmentFragBinding;
import com.stickware.jani5.gui.library.navigation.MainNavBar;

public class EditEquipmentFrag extends Fragment {

    private ComponentsEditEquipmentFragBinding mBinding;

    private static MainNavBar mBar;

    //TODO:  add equipment / modify for handling new model et cetera instead of new equipment item, need to make diff clear
    public EditEquipmentFrag(MainNavBar bar){
        mBar = bar;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = ComponentsEditEquipmentFragBinding.inflate(inflater, container, false);

        //Options
        setHasOptionsMenu(true);
        MainNavBar.setHasMenu(mBar, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO: need to set this to actually reference the object being built instead of the view
        setHasLife(mBinding.hasLifeSwitchCeef.isChecked());

        //Listeners
        mBinding.hasLifeSwitchCeef.setOnClickListener(view1 -> {
            setHasLife(mBinding.hasLifeSwitchCeef.isChecked());
            hideEditTextFocus();
        });

        mBinding.maxLifeEdittextCeef.setOnEditorActionListener((textView, i, keyEvent) -> {
            mBinding.maxLifeEdittextCeef.clearFocus();
            mBinding.cardview1Ceef.requestFocus();
            return false;
        });
    }

    private void setHasLife(boolean lifeChecked){
        if(lifeChecked){
            mBinding.setLifeVisible(View.VISIBLE);
        } else {
            mBinding.setLifeVisible(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Back Button
        if(item.getItemId() == android.R.id.home){
            //Hide keyboard
            InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
            //Navigates back via backstack
            requireActivity().getSupportFragmentManager().popBackStack();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void hideEditTextFocus(){
        InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
        mBinding.nameEdittextCeef.clearFocus();
        mBinding.descriptionEdittextCeef.clearFocus();
        mBinding.maxLifeEdittextCeef.clearFocus();
    }
}
