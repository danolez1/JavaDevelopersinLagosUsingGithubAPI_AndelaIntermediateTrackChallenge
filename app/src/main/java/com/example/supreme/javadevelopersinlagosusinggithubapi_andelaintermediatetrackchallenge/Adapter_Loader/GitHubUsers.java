package com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Adapter_Loader;

/**
 * Created by supreme on 6/24/17.
 */

@SuppressWarnings("ALL")
public class GitHubUsers {


    private String mUserImage;
    private String mUserName;
    private String mUrl;


    public GitHubUsers(String mUserImage, String mUserName, String mUrl) {
        this.mUserImage = mUserImage;
        this.mUserName = mUserName;
        this.mUrl = mUrl;

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

}



