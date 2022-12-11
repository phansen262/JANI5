package com.stickware.jani5.gui.library.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;

import com.stickware.jani5.databinding.ComponentsEditEquipmentFragBinding;
import com.stickware.jani5.databinding.DialogEquipmentEditModelBinding;
import com.stickware.jani5.databinding.RevitemEquipmentModelBinding;
import com.stickware.jani5.gui.library.components.adapters.MRevAdapter;
import com.stickware.jani5.gui.library.components.edit.EditEquipmentFrag;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentModel;

public class EditEquipmentModelDialog extends DialogFragment {

    private DialogEquipmentEditModelBinding mBinding;
    private final ViewDataBinding parentBinding;

    public EditEquipmentModelDialog(ViewDataBinding parentBinding){
        this.parentBinding = parentBinding;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        mBinding = DialogEquipmentEditModelBinding.inflate(inflater, null, false);

        builder.setView(mBinding.getRoot()).setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                saveToEditEquipment();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setTitle("Add Model");

        return builder.create();
    }

    public void saveToEditEquipment(){

        EquipmentModel eModel = new EquipmentModel(mBinding.nameEdittextDeem.getText().toString(),
                mBinding.labelEdittextDeem.getText().toString(), 1,
                Integer.parseInt(mBinding.maxlifeEdittextDeem.getText().toString()), 0);

        int insertLocation = EditEquipmentFrag.activeModels.size();
        EditEquipmentFrag.activeModels.add(eModel);

        MRevAdapter mRevAdapter = (MRevAdapter) ((ComponentsEditEquipmentFragBinding) parentBinding).revModelsCeef.getAdapter();
        mRevAdapter.updateItemList(EditEquipmentFrag.activeModels);
        mRevAdapter.notifyItemInserted(insertLocation);
    }
}
