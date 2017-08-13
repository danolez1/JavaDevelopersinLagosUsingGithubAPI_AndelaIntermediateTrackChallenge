package com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Adapter_Loader; /**
 * Created by supreme on 8/6/17.
 */

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Others.QueryUtils;

import java.util.List;

public class GitHubUsersLoader extends AsyncTaskLoader<List<GitHubUsers>> {
    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link GitHubUsersLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public GitHubUsersLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<GitHubUsers> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of github users.
        List<GitHubUsers> gitHubUsers = QueryUtils.fetchGitHubUserDetails(mUrl);
        return gitHubUsers;
    }
}