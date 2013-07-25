package com.novoda.stackoverflow.json;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StackoverflowPosts {
    @SerializedName("items")
    private List<Post> posts = new ArrayList<Post>();
    @SerializedName("quota_remaining")
    private int remainingRequests;
    @SerializedName("quota_max")
    private int maxRequests;
    @SerializedName("has_more")
    private boolean hasMore;

    public StackoverflowPosts(List<Post> posts, int remainingRequests, int maxRequests, boolean hasMore) {
        this.posts = posts;
        this.remainingRequests = remainingRequests;
        this.maxRequests = maxRequests;
        this.hasMore = hasMore;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public int getRemainingRequests() {
        return remainingRequests;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public boolean isHasMore() {
        return hasMore;
    }
}
