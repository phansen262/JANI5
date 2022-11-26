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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.stickware.jani5.databinding.ComponentsEditEquipmentFragBinding;
import com.stickware.jani5.databinding.RevitemEquipmentModelBinding;
import com.stickware.jani5.gui.library.components.adapters.MRevAdapter;
import com.stickware.jani5.gui.library.dialogs.EditEquipmentModelDialog;
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

        //Listener for has life switch
        mBinding.hasLifeSwitchCeef.setOnClickListener(view1 -> {
            setHasLife(mBinding.hasLifeSwitchCeef.isChecked());
            hideEditTextFocus();
        });
        //Launch dialog when asking to add model for
        mBinding.addModelButtonCeef.setOnClickListener(view1 -> {
            DialogFragment newFrag = new EditEquipmentModelDialog();
            newFrag.show(requireActivity().getSupportFragmentManager(), "model_edit");
        });

        mBinding.revModelsCeef.setAdapter(new MRevAdapter(5, (inflater, parent, viewType) ->
                new MRevAdapter.ViewHolder(RevitemEquipmentModelBinding.inflate(inflater, parent, false)), (binding, position) -> {
        }));
        mBinding.revModelsCeef.setLayoutManager(new LinearLayoutManager(requireContext()));
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
    }


}
