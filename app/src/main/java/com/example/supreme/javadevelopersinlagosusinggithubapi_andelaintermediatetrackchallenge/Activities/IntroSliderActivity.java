package com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;


import com.example.supreme.javadevelopersinlagosusinggithubapi_andelaintermediatetrackchallenge.R;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;

public class IntroSliderActivity extends AppIntro2 {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        {
            SharedPreferences sharedPreferences = this.getSharedPreferences("Supreme", 0);
            if (sharedPreferences.getBoolean("firstLaunch", false) == true) {
                startActivity(new Intent(this, GitHub_Users_LagosActivity.class));

            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("firstLaunch", true);
                editor.apply();

            }
        }

        finish();


        //noinspection deprecation
        addSlide(AppIntro2Fragment.newInstance("Andela", "Helping Build World-Class Development Teams", R.drawable.andela_logo, getResources().getColor(R.color.introSliderColor_1)));
        //noinspection deprecation
        addSlide(AppIntro2Fragment.newInstance("GitHub", "World's leading software development platform", R.drawable.github, getResources().getColor(R.color.introSliderColor_2)));
        setSlideOverAnimation();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onDonePressed() {
        super.onDonePressed();
        startActivity(new Intent(getApplicationContext(), GetStartedActivity.class));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(getApplicationContext(), GetStartedActivity.class));

    }

}
