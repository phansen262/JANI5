package com.stickware.jani5.gui.snav.workout_library;

import com.stickware.jani5.R;
import com.stickware.jani5.gui.snav.LibraryGenFrag;

public class WorkoutTabFrag extends LibraryGenFrag {

    @Override
    protected void addCreateView() {
        super.addCreateView();

    }

    @Override
    protected void addViewCreated(){

        hasTabs = true;
        mTabs = requireActivity().findViewById(R.id.tabs_swmf);
    }
}
