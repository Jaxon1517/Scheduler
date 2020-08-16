package com.example.scheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTasksActivity extends AppCompatActivity {

    EditText taskNameEditText;
    EditText startTimeEditText;
    EditText endTimeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);

        taskNameEditText = findViewById(R.id.task_name_edit_text);
        startTimeEditText = findViewById(R.id.start_time_edit_text);
        endTimeEditText = findViewById(R.id.end_time_edit_text);
    }

    public void createButtonPressed(View view) {
        Intent intent = new Intent(this, TasksActivity.class);

        String taskName = taskNameEditText.getText().toString();
        String startTime = startTimeEditText.getText().toString();
        String endTime = endTimeEditText.getText().toString();

        intent.putExtra("taskName", taskName);
        intent.putExtra("startTime", startTime);
        intent.putExtra("endTime", endTime);

        startActivity(intent);
    }
}