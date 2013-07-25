package com.novoda.stackoverflow.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

    private long questionId;
    private long created;
    private long lastActivity;
    private long score;
    private int answerCount;
    private long acceptedAnswer;
    private String title;
    private List<String> tags = new ArrayList<String>();
    private long viewCount;
    private Owner owner;
    private String urlLink;
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

    @JsonCreator
    public static Post from(
            @JsonProperty("question_id") long questionId,
            @JsonProperty("creation_date") long created,
            @JsonProperty("last_activity_date") long lastActivity,
            @JsonProperty("score") long score,
            @JsonProperty("answer_count") int answerCount,
            @JsonProperty("accepted_answer_id") long acceptedAnswer,
            @JsonProperty("title") String title,
            @JsonProperty("tags") List<String> tags,
            @JsonProperty("view_count") long viewCount,
            @JsonProperty("owner") Owner owner,
            @JsonProperty("link") String urlLink,
            @JsonProperty("is_answered") boolean isAnswered
    ) {
        return new Post(questionId, created, lastActivity, score, answerCount, acceptedAnswer, title, tags, viewCount, owner, urlLink, isAnswered);
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
