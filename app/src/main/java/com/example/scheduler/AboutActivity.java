package com.example.scheduler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;

public class AboutActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //adds first of intro slides
        addSlide(AppIntroFragment.newInstance(
                "Welcome to Defuse",
                "Unpacks all the volume causing stress inside your brain.",
                R.drawable.planiitlogo,
                ContextCompat.getColor(getApplicationContext(),R.color.mainRed)));
        addSlide(AppIntroFragment.newInstance(
                "Organization",
                "",
                R.drawable.planiitlogo,
                ContextCompat.getColor(getApplicationContext(),R.color.mainPurp)));
        addSlide(AppIntroFragment.newInstance(
                "Wellness",
                "Checks up on your mental health",
                R.drawable.planiitlogo,
                ContextCompat.getColor(getApplicationContext(),R.color.sndLight),
                Color.BLACK,
                Color.BLACK));
    }
    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Decide what to do when the user clicks on "Skip"
        startActivity(new Intent(getApplicationContext(),SurveyActivity.class));
        finish();

    }

    @Override
     public void onDonePressed(Fragment currentFragment ) {
        super.onDonePressed(currentFragment);
        // Decide what to do when the user clicks on "Done"
        startActivity(new Intent(getApplicationContext(),SurveyActivity.class));
        finish();
    }
}