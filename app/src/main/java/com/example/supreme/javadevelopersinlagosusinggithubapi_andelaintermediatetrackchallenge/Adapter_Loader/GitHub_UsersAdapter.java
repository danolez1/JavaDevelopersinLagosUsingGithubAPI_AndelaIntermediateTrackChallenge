package com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Adapter_Loader;

/**
 * Created by supreme on 6/24/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.R;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * An {@link GitHubUsers} knows how to create a list item layout for each githubusers
 * in the data source (a list of {@link GitHubUsers} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class GitHub_UsersAdapter extends ArrayAdapter<GitHubUsers> {

    /**
     * Constructs a new {@link GitHub_UsersAdapter}.
     *
     * @param context     of the app
     * @param gitHubUsers is the list of githubusers, which is the data source of the adapter
     */
    public GitHub_UsersAdapter(Context context, List<GitHubUsers> gitHubUsers) {
        super(context, 0, gitHubUsers);
    }

    /**
     * Returns a list item view that displays information about the githubusers at the given position
     * in the list of githubusers.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.github_users_list_item, parent, false);
        }
        GitHubUsers currentGitHubUsers = getItem(position);

        TextView userName = (TextView) listItemView.findViewById(R.id.user_name);
        userName.setText(currentGitHubUsers.getmUserName());

        ImageView userImage = (ImageView) listItemView.findViewById(R.id.user_image);
        Picasso.with(getContext()).load(currentGitHubUsers.getmUserImage()).into(userImage);

        TextView location = (TextView) listItemView.findViewById(R.id.state);
        location.setText("Lagos");


        return listItemView;
    }


}
