package com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Activities;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Adapter_Loader.GitHubUsers;
import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Adapter_Loader.GitHubUsersLoader;
import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Adapter_Loader.GitHub_UsersAdapter;
import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.R
        ;

import java.util.ArrayList;
import java.util.List;

public class GitHub_Users_LagosActivity extends AppCompatActivity implements LoaderCallbacks<List<GitHubUsers>> {

    private static final String GITHUB_REQUEST_URL = "https://api.github.com/search/users?q=language:java%20location:lagos";
    private static final int GITHUB_LOADER_ID = 1;
    private GitHub_UsersAdapter mAdapter;
    private TextView mEmptyStateTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github__users__lagos);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.setStatusBarColor(ContextCompat.getColor(this, R.color.list_items_header));
        }

        ListView gitHubListView = (ListView) findViewById(R.id.list);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        gitHubListView.setEmptyView(mEmptyStateTextView);
        mAdapter = new GitHub_UsersAdapter(this, new ArrayList<GitHubUsers>());
        gitHubListView.setAdapter(mAdapter);


        gitHubListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                GitHubUsers currentGitHubUsers = mAdapter.getItem(position);

                Intent intent = new Intent(GitHub_Users_LagosActivity.this, UserDetailsActivity.class);

                assert currentGitHubUsers != null;
                intent.putExtra("user_html_uri", currentGitHubUsers.getmUrl());
                intent.putExtra("userImage", currentGitHubUsers.getmUserImage());
                intent.putExtra("userName", currentGitHubUsers.getmUserName());

                startActivity(intent);
            }
        });

        if (!isNetworkAvailable()) {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
            Snackbar snackbar = Snackbar
                    .make(relativeLayout, getString(R.string.no_internet_connection), Snackbar.LENGTH_INDEFINITE)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            View loadingIndicator = findViewById(R.id.loading_indicator);
                            loadingIndicator.setVisibility(View.VISIBLE);
                            LoaderManager loaderManager = getLoaderManager();
                            loaderManager.initLoader(GITHUB_LOADER_ID, null, GitHub_Users_LagosActivity.this);
                        }
                    });

            snackbar.show();
        } else {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(GITHUB_LOADER_ID, null, this);
        }
    }

    @Override
    public Loader<List<GitHubUsers>> onCreateLoader(int i, Bundle bundle) {

        Uri baseUri = Uri.parse(GITHUB_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        return new GitHubUsersLoader(this, uriBuilder.toString());

    }

    @Override
    public void onLoadFinished(Loader<List<GitHubUsers>> loader, final List<GitHubUsers> gitHubUsers) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        mEmptyStateTextView.setText(R.string.no_gitHub_users);
        //Clear the adapter of previous gitHubUsers data
        mAdapter.clear();

        if (gitHubUsers != null && !gitHubUsers.isEmpty()) {
            mAdapter.addAll(gitHubUsers);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<GitHubUsers>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Intent settingsIntent = new Intent(this, AboutAppActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
