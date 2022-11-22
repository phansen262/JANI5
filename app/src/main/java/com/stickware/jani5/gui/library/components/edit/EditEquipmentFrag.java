package com.stickware.jani5.gui.library.components.edit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.ComponentsEditEquipmentFragBinding;
import com.stickware.jani5.gui.library.navigation.MainNavBar;

public class EditEquipmentFrag extends Fragment {

    private ComponentsEditEquipmentFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = ComponentsEditEquipmentFragBinding.inflate(inflater, container, false);

        //Options
        setHasOptionsMenu(true);
        //MainNavBar.setHasMenu();

        return mBinding.getRoot();
    }
}
