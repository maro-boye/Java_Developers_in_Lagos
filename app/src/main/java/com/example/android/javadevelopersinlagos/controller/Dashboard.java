package com.example.android.javadevelopersinlagos.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.javadevelopersinlagos.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Maro on 9/16/2017.
 */

public class Dashboard extends AppCompatActivity {
    TextView GithubProfile, UserName;
    Toolbar mActionBarToolbar;
    ImageView ProfileImage;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        UserName = (TextView) findViewById(R.id.userName);
        GithubProfile = (TextView) findViewById(R.id.githubProfile);
        ProfileImage = (ImageView) findViewById(R.id.profileImage);

        String userName = getIntent().getExtras().getString("login");
        String githubProfile = getIntent().getExtras().getString("html_url");
        String profileImage = getIntent().getExtras().getString("avatar_url");

        UserName.setText(userName);

        GithubProfile.setText(githubProfile);
        Linkify.addLinks(GithubProfile, Linkify.WEB_URLS);

        Picasso.with(this)
                .load(profileImage)
                .placeholder(R.drawable.avatar)
                .into(ProfileImage);

        getSupportActionBar().setTitle("Dashboard");

    }

    private Intent shareProfile() {
        String userName = getIntent().getExtras().getString("login");
        String githubProfile = getIntent().getExtras().getString("html_url");

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this awesome developer @" + userName + ", " + githubProfile)
                .getIntent();
        return shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.share);
        menuItem.setIntent(shareProfile());
        return true;
    }
}