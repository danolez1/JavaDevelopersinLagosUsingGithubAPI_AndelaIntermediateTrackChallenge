package com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Adapter_Loader;

/**
 * Created by supreme on 6/24/17.
 */

public class GitHubUsers {

    private String mUserImage;
    private String mUserName;
    private String mUrl;
    private int userId;


    public GitHubUsers(String mUserImage, String mUserName, String mUrl, int userId) {
        this.mUserImage = mUserImage;
        this.mUserName = mUserName;
        this.mUrl = mUrl;
        this.userId = userId;
    }


    public String getmUserImage() {
        return mUserImage;
    }

    public String getmUserName() {
        return mUserName;
    }

    public String getmUrl() {
        return mUrl;
    }

    public int getUserId() {
        return userId;
    }
}



