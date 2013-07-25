package com.novoda.stackoverflow.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StackoverflowPosts {
    private List<Post> posts = new ArrayList<Post>();
    private int remainingRequests;
    private int maxRequests;
    private boolean hasMore;

    public StackoverflowPosts(List<Post> posts, int remainingRequests, int maxRequests, boolean hasMore) {
        this.posts = posts;
        this.remainingRequests = remainingRequests;
        this.maxRequests = maxRequests;
        this.hasMore = hasMore;
    }

    @JsonCreator
    public static StackoverflowPosts from(
            @JsonProperty("items") List<Post> posts,
            @JsonProperty("quota_remaining") int remainingRequests,
            @JsonProperty("quota_max") int maxRequests,
            @JsonProperty("has_more") boolean hasMore
    ) {
        return new StackoverflowPosts(posts, remainingRequests, maxRequests, hasMore);
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
