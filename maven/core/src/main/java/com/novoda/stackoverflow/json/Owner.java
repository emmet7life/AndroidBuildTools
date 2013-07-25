package com.novoda.stackoverflow.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

    private long userId;
    private String name;
    private long reputation;
    private String userType;
    private String profileImage;
    private String profileLink;
    private int acceptRate;

    public Owner(long userId, String name, long reputation, String userType, String profileImage, String profileLink, int acceptRate) {
        this.userId = userId;
        this.name = name;
        this.reputation = reputation;
        this.userType = userType;
        this.profileImage = profileImage;
        this.profileLink = profileLink;
        this.acceptRate = acceptRate;
    }

    @JsonCreator
    public static Owner from(
            @JsonProperty("user_id") long userId,
            @JsonProperty("display_name") String name,
            @JsonProperty("reputation") long reputation,
            @JsonProperty("user_type") String userType,
            @JsonProperty("profile_image") String profileImage,
            @JsonProperty("link") String profileLink,
            @JsonProperty("accept_rate") int acceptRate
    ) {
        return new Owner(userId, name, reputation, userType, profileImage, profileLink, acceptRate);
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public long getReputation() {
        return reputation;
    }

    public String getUserType() {
        return userType;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getProfileLink() {
        return profileLink;
    }

    public int getAcceptRate() {
        return acceptRate;
    }
}
