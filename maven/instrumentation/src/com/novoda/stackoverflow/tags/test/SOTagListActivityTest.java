package com.novoda.stackoverflow.tags.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.novoda.stackoverflow.R;
import com.novoda.stackoverflow.tags.SOTagListActivity;

import static android.test.ViewAsserts.assertOnScreen;

public class SOTagListActivityTest extends ActivityInstrumentationTestCase2<SOTagListActivity> {

    private SOTagListActivity activity;

    public SOTagListActivityTest() {
        super(SOTagListActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        activity = getActivity();
    }

    public void testActivity() {
        assertNotNull(activity);
    }

    public void testUIComponentsPresent() {
        View view = activity.getWindow().getDecorView();
        assertOnScreen(view, view.findViewById(R.id.simple_list));
    }
}

