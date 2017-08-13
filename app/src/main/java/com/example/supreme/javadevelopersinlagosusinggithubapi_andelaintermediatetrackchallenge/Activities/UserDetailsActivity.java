package com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Adapter_Loader.GitHubUsers_Details_Adapter;
import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.R;

public class UserDetailsActivity extends AppCompatActivity {
    ImageView user_image;
    TextView userName;
    TextView user_html_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.setStatusBarColor(ContextCompat.getColor(this,R.color.list_items_header));
        }

        user_image = (ImageView) findViewById(R.id.user_image);
        userName = (TextView) findViewById(R.id.user_name);
        user_html_url = (TextView) findViewById(R.id.user_html_url);
        String username = getIntent().getExtras().getString("userName");
        userName.setText(username);

        String user_url = getIntent().getExtras().getString("user_html_uri");
        user_html_url.setText(user_url);

    }

    public void onClick(View view) {
        Uri gitHubUsersUri = Uri.parse(getIntent().getExtras().getString("user_html_uri"));
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, gitHubUsersUri);
        startActivity(websiteIntent);
    }

    @SuppressWarnings("deprecation")
    public void shareContent(View view) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        share.putExtra(Intent.EXTRA_SUBJECT, getIntent().getExtras().getString("userName"));
        share.putExtra(Intent.EXTRA_SUBJECT, getIntent().getExtras().getString("user_html_uri"));
        startActivity(Intent.createChooser(share, "Share Content with..."));
    }

}
