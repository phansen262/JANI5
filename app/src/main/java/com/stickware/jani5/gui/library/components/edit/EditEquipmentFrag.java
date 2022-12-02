package com.stickware.jani5.gui.library.components.edit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

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
import com.stickware.jani5.logic.app_objects.equipment.EquipmentLifespan;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentModel;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentTemplate;
import com.stickware.jani5.logic.dictionaries.Sport;
import com.stickware.jani5.logic.dictionaries.SportServer;

import java.util.ArrayList;
import java.util.List;

public class EditEquipmentFrag extends Fragment {

    //UI
    private ComponentsEditEquipmentFragBinding mBinding;
    private static MainNavBar mBar;

    //App Objects
    public static EquipmentTemplate mTemplate;
    public static EquipmentLifespan mLifespan;
    public static List<EquipmentModel> activeModels;
    public static List<EquipmentModel> retiredModels;

    //TODO:  add equipment / modify for handling new model et cetera instead of new equipment item, need to make diff clear
    public EditEquipmentFrag(MainNavBar bar, EquipmentTemplate inputTemplate){

        mBar = bar;

        if(inputTemplate != null) {
            mTemplate = inputTemplate;
            mLifespan = inputTemplate.getMEquipmentLifespan();
            activeModels = inputTemplate.getActiveModels();
            retiredModels = inputTemplate.getRetiredModels();
        } else {
            mLifespan = new EquipmentLifespan(EquipmentLifespan.LifespanType.MILEAGE, 1);
            activeModels = new ArrayList<>();
            retiredModels = new ArrayList<>();
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Setup app objects
        if(mTemplate == null){
            mTemplate = new EquipmentTemplate("", "", Sport.NONE, false, null);
        }

        //UI
        mBinding = ComponentsEditEquipmentFragBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        MainNavBar.setHasMenu(mBar, false);
        return mBinding.getRoot();
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Logic for Location Specific Switch
        if(mTemplate.isLocationSpecific()){
            mBinding.locationSpecificSwitchCeef.setChecked(true);
        }
        mBinding.locationSpecificSwitchCeef.setOnCheckedChangeListener((compoundButton, b) -> {
            mTemplate.setLocationSpecific(b);
            hideEditTextFocus();
        });

        //Logic for hasLifeSwitch
        mBinding.hasLifeSwitchCeef.setChecked(mTemplate.getMEquipmentLifespan() != null);
        setLifeVisible(mTemplate.getMEquipmentLifespan() != null);
        mBinding.hasLifeSwitchCeef.setOnCheckedChangeListener((compoundButton, b) -> {
            setLifeVisible(b);
            hideEditTextFocus();
            if(b){
                mTemplate.setMEquipmentLifespan(mLifespan);
            } else {
                mTemplate.setMEquipmentLifespan(null);
            }
        });

        //Logic for radiobutton bar
        if(mLifespan.getLifeIncrementFactor() == 1) {
            mBinding.radio0Ceef.setChecked(true);
        } else {
            mBinding.radio1Ceef.setChecked(true);
        }

        mBinding.radioGroupCeef.setOnCheckedChangeListener((radioGroup, i) -> {
            if(i == 0){
                mLifespan.setLifeIncrementFactor(1);
            } else {
                mLifespan.setLifeIncrementFactor(-1);
            }
        });

        //Logic for spinner for increment
        List<String> incrementTypeSpinnerList = EquipmentLifespan.getEnumDisplayList();
        ArrayAdapter<String> itscAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, incrementTypeSpinnerList);
        itscAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBinding.incrementTypeSpinnerCeef.setAdapter(itscAdapter);
        mBinding.incrementTypeSpinnerCeef.setOnTouchListener((view12, motionEvent) -> {
            hideEditTextFocus();
            return false;
        });
        mBinding.incrementTypeSpinnerCeef.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                mLifespan.setLifespanType(EquipmentLifespan.getTypeFromDisplay(incrementTypeSpinnerList.get(i)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Set up spinner
        mBinding.sportSpinnerCeef.setOnTouchListener((view13, motionEvent) -> {
            hideEditTextFocus();
            return false;
        });
        mBinding.sportSpinnerCeef.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ArrayAdapter<String> sscAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, SportServer.getEnumDisplayList());
        sscAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBinding.sportSpinnerCeef.setAdapter(sscAdapter);


        //Set up rev
        mBinding.revModelsCeef.setAdapter(new MRevAdapter(activeModels.size(), (inflater, parent, viewType) ->
                new MRevAdapter.ViewHolder(RevitemEquipmentModelBinding.inflate(inflater, parent, false)), (binding, position) -> {
        }));
        mBinding.revModelsCeef.setLayoutManager(new LinearLayoutManager(requireContext()));

        //Launch dialog when asking to add model for
        mBinding.addModelButtonCeef.setOnClickListener(view1 -> {
            DialogFragment newFrag = new EditEquipmentModelDialog(mBinding);
            newFrag.show(requireActivity().getSupportFragmentManager(), "model_edit");
//            mBinding.revModelsCeef.setAdapter(new MRevAdapter(activeModels.size(), (inflater, parent, viewType) ->
//                    new MRevAdapter.ViewHolder(RevitemEquipmentModelBinding.inflate(inflater, parent, false)), (binding, position) -> {
//            }));
//            mBinding.revModelsCeef.setLayoutManager(new LinearLayoutManager(requireContext()));
        });
    }

    private void setLifeVisible(boolean lifeChecked){
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
