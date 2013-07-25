package com.novoda.stackoverflow.posts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.novoda.stackoverflow.R;
import com.novoda.stackoverflow.json.Post;

import java.util.List;

public class PostsAdapter extends ArrayAdapter<Post> {

    private final Context context;
    private final List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts){
        super(context, 0, posts);
        this.context = context;
        this.posts = posts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.post_list_item, parent, false);
        }
        Post post = posts.get(position);
        ((TextView) convertView.findViewById(R.id.post_title)).setText(post.getTitle());

        return convertView;
    }
}
