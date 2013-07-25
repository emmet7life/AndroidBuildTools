package com.novoda.stackoverflow.tags;

import android.content.Intent;
import android.widget.ListView;

import com.novoda.stackoverflow.R;
import com.novoda.stackoverflow.matcher.IntentMatcher;
import com.novoda.stackoverflow.posts.PostsListActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class SOTagListActivityShould {

    private final TagListActivity activity = Mockito.spy(new TagListActivity());

    private ListView listView;

    @Before
    public void setUp() throws Exception {
        activity.onCreate(null);
        listView = (ListView)activity.findViewById(R.id.simple_list);
    }

    @Test
    public void shouldHaveFiveItemsInLIst() throws Exception {
        Assert.assertEquals(listView.getCount(), 5);
    }

    @Test
    public void shouldOpenPostActivityOnListClick() throws Exception{
        listView.performItemClick(listView, 0, 0);
        verify(activity).startActivity(IntentMatcher.match(new Intent(activity, PostsListActivity.class)));
    }
}
