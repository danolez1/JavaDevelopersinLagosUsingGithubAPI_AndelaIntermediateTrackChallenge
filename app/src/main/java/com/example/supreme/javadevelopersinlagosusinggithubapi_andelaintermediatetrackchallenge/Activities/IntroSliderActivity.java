package com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Others.PrefManager;
import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.R;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;

public class IntroSliderActivity extends AppIntro2 {
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }

        //noinspection deprecation
        addSlide(AppIntro2Fragment.newInstance("Andela", "Helping Build World-Class Development Teams", R.drawable.andela_logo, getResources().getColor(R.color.introSliderColor_1)));
        //noinspection deprecation
        addSlide(AppIntro2Fragment.newInstance("GitHub", "World's leading software development platform", R.drawable.github, getResources().getColor(R.color.introSliderColor_2)));
        //noinspection deprecation
        addSlide(AppIntro2Fragment.newInstance("Get Started", "An Android application to retrieve a list of Java Developers in Lagos using the GitHub API", R.drawable.slide_3, getResources().getColor(R.color.introSliderColor_3)));
        setSlideOverAnimation();
    }


    @SuppressWarnings("deprecation")
    @Override
    public void onDonePressed() {
        super.onDonePressed();
        launchHomeScreen();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        launchHomeScreen();

    }

    public void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(IntroSliderActivity.this, GitHub_Users_LagosActivity.class));
        finish();
    }


}
