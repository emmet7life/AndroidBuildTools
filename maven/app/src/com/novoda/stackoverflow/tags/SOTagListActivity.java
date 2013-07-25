package com.novoda.stackoverflow.tags;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.novoda.stackoverflow.R;
import com.novoda.stackoverflow.posts.SOPostListActivity;

public class SOTagListActivity extends FragmentActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list);

        ListView listView = (ListView) findViewById(R.id.simple_list);
        String[] tags = tagsFromResources();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.tags_list_item, tags);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private String[] tagsFromResources() {
        return getResources().getStringArray(R.array.tags_title_array);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent postsListActivity = new Intent(this, SOPostListActivity.class);
        postsListActivity.putExtra(SOPostListActivity.SELECTED_TAG, tagsFromResources()[position]);
        startActivity(postsListActivity);
    }
}
