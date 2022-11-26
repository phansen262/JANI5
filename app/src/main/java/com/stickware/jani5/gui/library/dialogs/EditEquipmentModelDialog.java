package com.stickware.jani5.gui.library.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.fragment.app.DialogFragment;

import com.stickware.jani5.databinding.DialogEquipmentEditModelBinding;

public class EditEquipmentModelDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        DialogEquipmentEditModelBinding mBinding = DialogEquipmentEditModelBinding.inflate(inflater, null, false);

        builder.setView(mBinding.getRoot()).setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setTitle("Add Model");

        return builder.create();
    }
}
