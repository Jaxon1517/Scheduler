package com.example.scheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SurveyActivity extends AppCompatActivity {

//    ArrayAdapter<ActivityPosts> aPosts = new ArrayList<>();

    EditText wakeUpEditText;
    EditText sleepEditText;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        wakeUpEditText = findViewById(R.id.wakeUpEditText);
        sleepEditText = findViewById(R.id.sleepEditText);
        nextButton = findViewById(R.id.nextButton);
    }

    public void nextButtonPressed(View view) {
        Intent intent = new Intent(this, AddActivity.class);

        intent.putExtra("wakeUpTime", wakeUpEditText.getText().toString());
        intent.putExtra("sleepTime", sleepEditText.getText().toString());

        startActivity(intent);
    }
}