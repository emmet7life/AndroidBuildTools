package com.novoda.stackoverflow.json;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Post {

    @SerializedName("question_id")
    private long questionId;
    @SerializedName("creation_date")
    private long created;
    @SerializedName("last_activity_date")
    private long lastActivity;
    @SerializedName("score")
    private long score;
    @SerializedName("answer_count")
    private int answerCount;
    @SerializedName("accepted_answer_id")
    private long acceptedAnswer;
    @SerializedName("title")
    private String title;
    @SerializedName("tags")
    private List<String> tags = new ArrayList<String>();
    @SerializedName("view_count")
    private long viewCount;
    @SerializedName("owner")
    private Owner owner;
    @SerializedName("link")
    private String urlLink;
    @SerializedName("is_answered")
    private boolean isAnswered;

    public Post(long questionId, long created, long lastActivity, long score, int answerCount, long acceptedAnswer,
                String title, List<String> tags, long viewCount, Owner owner, String urlLink, boolean answered) {
        this.questionId = questionId;
        this.created = created;
        this.lastActivity = lastActivity;
        this.score = score;
        this.answerCount = answerCount;
        this.acceptedAnswer = acceptedAnswer;
        this.title = title;
        this.tags = tags;
        this.viewCount = viewCount;
        this.owner = owner;
        this.urlLink = urlLink;
        isAnswered = answered;
    }

    public long getQuestionId() {
        return questionId;
    }

    public long getCreated() {
        return created;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public long getScore() {
        return score;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public long getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }

    public long getViewCount() {
        return viewCount;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public boolean isAnswered() {
        return isAnswered;
    }
}
