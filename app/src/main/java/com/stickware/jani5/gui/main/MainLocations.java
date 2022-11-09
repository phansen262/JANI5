package com.stickware.jani5.gui.main;

import androidx.fragment.app.Fragment;

import com.stickware.jani5.R;
import com.stickware.jani5.gui.main.day.DayMainFrag;
import com.stickware.jani5.gui.main.progress.ProgressMainFrag;
import com.stickware.jani5.gui.main.timeline.TimelineMainFrag;
import com.stickware.jani5.gui.main.week.WeekMainFrag;

public enum MainLocations {

    Day(new DayMainFrag(), R.string.day_title_bnav),
    Week(new WeekMainFrag(), R.string.week_title_bnav),
    Timeline(new TimelineMainFrag(), R.string.timeline_title_bnav),
    Progress(new ProgressMainFrag(), R.string.progress_title_bnav);

    final Fragment mFrag;
    final int mKey;

    MainLocations(Fragment frag, int key) {
        mFrag = frag;
        mKey = key;
    }
}
