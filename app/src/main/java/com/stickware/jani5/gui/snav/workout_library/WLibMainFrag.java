package com.stickware.jani5.gui.snav.workout_library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.stickware.jani5.R;
import com.stickware.jani5.databinding.SnavWlMainFragBinding;

public class WLibMainFrag extends Fragment {

    private SnavWlMainFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = SnavWlMainFragBinding.inflate(inflater, container, false);
        //Default is to have exercises when navigated to the snav location
        //Todo: change to have dynamic behavior as to what is default loaded
        requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.frag_container_swmf, new ExerciseTabFrag()).commit();

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        mBinding.tabsSwmf.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(mBinding.tabsSwmf.getSelectedTabPosition() == 0){
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_swmf, new ExerciseTabFrag()).commit();
                } else if(mBinding.tabsSwmf.getSelectedTabPosition() == 1){
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_swmf, new RoutineTabFrag()).commit();
                } else {
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_swmf, new WorkoutTabFrag()).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
