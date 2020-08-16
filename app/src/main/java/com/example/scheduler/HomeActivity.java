package com.example.scheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

    }

    public void goHome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void goTask(View view){
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
    }
    public void goAddTask(View view){
        Intent intent = new Intent(this, AddTasksActivity.class);
        startActivity(intent);
    }
}