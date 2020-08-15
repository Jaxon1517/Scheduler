package com.example.scheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Survey extends AppCompatActivity {

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
}