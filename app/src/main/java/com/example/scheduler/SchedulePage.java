package com.example.scheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SchedulePage extends AppCompatActivity {
    ActivityPostAdapter ActivityPostsAdapter;
    ArrayList<ActivityPosts> Posts = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);
        ListView aView = findViewById(R.id.activity);


        //Create and Set Adapter
        ActivityPostsAdapter = new ActivityPostAdapter(this, Posts);
        aView.setAdapter(ActivityPostsAdapter);
    }
}