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

    //Enum to control viewstate of general location
    public enum FragState {
        EQUIPMENTMAIN(true, 0),
        EQUIPMENTLIST(false, 0),
        LOCATIONMAIN(true, 1),
        LOCATIONLIST(false, 1);

        private final boolean hasMenu;
        private final int tabIndex;

        FragState(boolean menu, int index){
            hasMenu = menu;
            tabIndex = index;
        }

        public boolean getHasMenu(){return hasMenu;}
        public int getTabIndex(){return tabIndex;}
    }

    private SnavSlMainFragBinding mBinding;
    //TODO: Instead of this being static, find way to reference instance of fragment for getAcitvity() ??
    public static FragState mFragState;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(mFragState == null){
            mFragState = FragState.EQUIPMENTMAIN;
        }

        mBinding = SnavSlMainFragBinding.inflate(inflater, container, false);

        //Default is to have equipment when navigated to the snav location from outside, now should move to last location when internal
        if(mFragState.getTabIndex() == 0) {
            mBinding.tabsSsmf.getTabAt(0).select();
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_ssmf, new EquipmentTabFrag()).commit();
        } else {
            mBinding.tabsSsmf.getTabAt(1).select();
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_ssmf, new LocationTabFrag()).commit();
        }

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        //Listener to move between tabs
        mBinding.tabsSsmf.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(mBinding.tabsSsmf.getSelectedTabPosition() == 0){
                    mFragState = FragState.EQUIPMENTMAIN;
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_ssmf, new EquipmentTabFrag()).commit();
                } else {
                    mFragState = FragState.LOCATIONMAIN;
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
