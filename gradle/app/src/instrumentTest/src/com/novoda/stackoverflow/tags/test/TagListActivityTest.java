package com.novoda.stackoverflow.tags.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.novoda.stackoverflow.R;
import com.novoda.stackoverflow.tags.TagListActivity;

import static android.test.ViewAsserts.assertOnScreen;

public class TagListActivityTest extends ActivityInstrumentationTestCase2<TagListActivity> {

    private TagListActivity activity;

    public TagListActivityTest() {
        super(TagListActivity.class);
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

