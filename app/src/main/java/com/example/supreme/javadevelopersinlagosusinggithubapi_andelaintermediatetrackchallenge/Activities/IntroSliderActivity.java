package com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;


import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.R;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;

public class IntroSliderActivity extends AppIntro2 {

   @Override
protected void onCreate(Bundle savedInstanceState) {

    ...

    //  Declare a new thread to do a preference check
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            //  Initialize SharedPreferences
            SharedPreferences getPrefs = PreferenceManager
                    .getDefaultSharedPreferences(getBaseContext());

            //  Create a new boolean and preference and set it to true
            boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

            //  If the activity has never started before...
            if (isFirstStart) {

                runOnUiThread(new Runnable() {
                  @Override public void run() {
                    startActivity(new Intent(IntroSliderActivity.this, MainActivity.class););
                  }
                });

                //  Make a new preferences editor
                SharedPreferences.Editor e = getPrefs.edit();

                //  Edit preference to make it false because we don't want this to run again
                e.putBoolean("firstStart", false);

                //  Apply changes
                e.apply();
            }
        }
    });

    // Start the thread
    t.start();

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
        startActivity(new Intent(getApplicationContext(), GitHub_Users_LagosActivity.class));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(getApplicationContext(), GitHub_Users_LagosActivity.class));

    }


}
