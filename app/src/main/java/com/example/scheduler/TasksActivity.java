package com.example.scheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    ListView list;

    TaskAdapter adapter;
    ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        list = findViewById(R.id.tasks_list);

        adapter = new TaskAdapter(this, tasks);
        list.setAdapter(adapter);
    }
}