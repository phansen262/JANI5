package com.stickware.jani5.gui.snav.workout_library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.SnavWlWorkoutTabFragBinding;

public class WorkoutTabFrag extends Fragment {

    private SnavWlWorkoutTabFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = SnavWlWorkoutTabFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
