package com.novoda.stackoverflow.tags.test;

import android.test.ActivityInstrumentationTestCase2;

import com.novoda.stackoverflow.tags.SOTagListActivity;

public class SOTagListActivityTest extends ActivityInstrumentationTestCase2<SOTagListActivity> {

    public SOTagListActivityTest() {
        super(SOTagListActivity.class);
    }

    public void testActivity() {
        SOTagListActivity activity = getActivity();
        assertNotNull(activity);
    }
}

