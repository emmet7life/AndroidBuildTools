package com.novoda.stackoverflow.json;

import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("user_id")
    private long userId;
    @SerializedName("display_name")
    private String name;
    @SerializedName("reputation")
    private long reputation;
    @SerializedName("user_type")
    private String userType;
    @SerializedName("profile_image")
    private String profileImage;
    @SerializedName("link")
    private String profileLink;
    @SerializedName("accept_rate")
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
