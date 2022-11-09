package com.stickware.jani5.gui.snav.support_library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.stickware.jani5.R;
import com.stickware.jani5.databinding.SnavSlMainFragBinding;

public class SLibMainFrag extends Fragment {

    private SnavSlMainFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = SnavSlMainFragBinding.inflate(inflater, container, false);
        //Default is to have equipment when navigated to the snav location
        //Todo: change to have dynamic behavior as to what is default loaded
        requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.frag_container_ssmf, new EquipmentTabFrag()).commit();

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        mBinding.tabsSsmf.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(mBinding.tabsSsmf.getSelectedTabPosition() == 0){
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_ssmf, new EquipmentTabFrag()).commit();
                } else {
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_ssmf, new LocationTabFrag()).commit();
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
