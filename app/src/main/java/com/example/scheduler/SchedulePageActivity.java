package com.example.scheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SchedulePageActivity extends AppCompatActivity {
    TaskAdapter adapter;

    ArrayList<Task> tasks = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);
        ListView aView = findViewById(R.id.activity);


        //Create and Set Adapter
        adapter = new TaskAdapter(this, tasks);
        aView.setAdapter(adapter);
    }
}