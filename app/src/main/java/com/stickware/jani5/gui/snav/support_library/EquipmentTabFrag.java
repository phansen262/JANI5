package com.stickware.jani5.gui.snav.support_library;

import com.stickware.jani5.R;
import com.stickware.jani5.gui.snav.LibraryGenFrag;

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
    }
}
