package com.stickware.jani5.gui.snav.support_library;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.stickware.jani5.R;
import com.stickware.jani5.databinding.RevitemEquipmentTemplateBinding;
import com.stickware.jani5.gui.library.components.adapters.MRevAdapter;
import com.stickware.jani5.gui.library.components.edit.EditEquipmentFrag;
import com.stickware.jani5.gui.snav.LibraryGenFrag;
import com.stickware.jani5.gui.snav.SnavActivity;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentServer;

public class EquipmentTabFrag extends LibraryGenFrag {

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

        //Set adapter for equipment list
        genBinding.recyclerSglbf.setAdapter(new MRevAdapter(EquipmentServer.activeTemplates, ((inflater, parent, viewType) ->
                new MRevAdapter.ViewHolder(RevitemEquipmentTemplateBinding.inflate(inflater, parent, false))),
                ((binding, position) -> {
                    RevitemEquipmentTemplateBinding itemBinding = (RevitemEquipmentTemplateBinding) binding;

                    itemBinding.setName(EquipmentServer.activeTemplates.get(position).getMName());
                    itemBinding.setDescription(EquipmentServer.activeTemplates.get(position).getMName());

                    itemBinding.menubuttonRet.setOnClickListener(view -> {
                        PopupMenu menu = new PopupMenu(requireContext(), itemBinding.menubuttonRet);
                        menu.getMenuInflater().inflate(R.menu.equipment_model, menu.getMenu());
                        menu.setOnMenuItemClickListener(menuItem -> {
                            if(menuItem.getItemId() == R.id.edit_em_menus){
                                Toast.makeText(requireContext(), "Selected " + menuItem.getTitle(), Toast.LENGTH_LONG).show();
                            } else if(menuItem.getItemId() == R.id.retire_em_menus){
                                Toast.makeText(requireContext(), "Selected " + menuItem.getTitle(), Toast.LENGTH_LONG).show();
                            }
                            return true;
                        });
                        menu.show();
                    });
                })));
        genBinding.recyclerSglbf.setLayoutManager(new LinearLayoutManager(requireContext()));

        //Setup new buttons
        genBinding.newButtonSglbf.setOnClickListener(view -> {
            //Very important to set hasOptionsMenu to false, otherwise the back code will still run from this frag
            setHasOptionsMenu(false);
            SnavActivity.hasMenuBar = false;
            //Move to next frag
            /*requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_sa,
                    new EditEquipmentFrag(SnavActivity.mainNavBar, null)).addToBackStack("").commit();*/
            EquipmentServer.launchNewEquipmentFrag(requireActivity(), R.id.frag_container_sa, SnavActivity.mainNavBar);
        });
        genBinding.newFloatingButtonSglbf.setOnClickListener(view -> {

            //Very important to set hasOptionsMenu to false, otherwise the back code will still run from this frag
            setHasOptionsMenu(false);
            SnavActivity.hasMenuBar = false;
            //Hide the keyboard if needed
            InputMethodManager imm = (InputMethodManager) requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0);
            //Move to next frag
            EquipmentServer.launchNewEquipmentFrag(requireActivity(), R.id.frag_container_sa, SnavActivity.mainNavBar);
        });
    }

    @Override
    protected void setSearchSelectListener(){

        //Called when search bar is selected
        if(SLibMainFrag.mFragState.getHasMenu()) {
            SLibMainFrag.mFragState = SLibMainFrag.FragState.EQUIPMENTLIST;
            setListView();
        }
    }

    @Override
    protected void setBackListener(){

        //Called when back is selected
        SLibMainFrag.mFragState = SLibMainFrag.FragState.EQUIPMENTMAIN;
        setMain();
    }
}
