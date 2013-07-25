package com.novoda.stackoverflow.posts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.novoda.stackoverflow.R;
import com.novoda.stackoverflow.json.StackoverflowPosts;
import com.novoda.stackoverflow.loader.TaggedPostsLoader;
import com.novoda.stackoverflow.utils.URIFactory;

import java.net.URI;
import java.net.URISyntaxException;

public class SOPostListActivity extends FragmentActivity implements TaggedPostsLoader.Callback {

    public static final String SELECTED_TAG = "selectedTag";
    private ListView listView;
    private StackoverflowPosts posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list);

        listView = (ListView) findViewById(R.id.simple_list);

        Intent intent = getIntent();
        if (intent.hasExtra(SELECTED_TAG)) {
            loadPosts(intent.getStringExtra(SELECTED_TAG));
        }
    }

    private void loadPosts(String queriedTag) {
        new TaggedPostsLoader(this, getApplicationContext(), taggerPostsUri(queriedTag), getSupportLoaderManager(), 1).restart();
    }

    private URI taggerPostsUri(String queriedTag) {
        return URIFactory.searchByTag(queriedTag);
    }

    @Override
    public void onLoadFinished(JsonObject jsonObject) {
        Gson gson = new Gson();
        posts = gson.fromJson(jsonObject, StackoverflowPosts.class);
        Log.e(SOPostListActivity.class.getSimpleName(), "Posts extracted from JSON");
        updateView();
    }

    private void updateView(){
        PostsAdapter adapter = new PostsAdapter(getApplicationContext(), posts.getPosts());
        listView.setAdapter(adapter);
    }
}
