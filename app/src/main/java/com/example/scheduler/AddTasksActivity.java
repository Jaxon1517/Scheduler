package com.example.scheduler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTasksActivity extends AppCompatActivity {

    EditText taskNameEditText;
    TextView startTimeEditText;
    TextView endTimeEditText;
    TextView Timer;
    int t1hour, t1minute;
    TextView Timer2;
    int t1hour2, t1minute2;
    DatabaseReference databasePosts;
    FirebaseDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);

        taskNameEditText = findViewById(R.id.task_name_edit_text);
        startTimeEditText = findViewById(R.id.start_time_edit_text);
        endTimeEditText = findViewById(R.id.end_time_edit_text);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databasePosts = database.getReference().child("Tasks");
        Timer = findViewById(R.id.start_time_edit_text);
        Timer2 = findViewById(R.id.end_time_edit_text);


        Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        AddTasksActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1hour = hourOfDay;
                                t1minute = minute;

                                String time = t1hour + ":" + t1minute;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    Timer.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },12,0,false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t1hour,t1minute);
                timePickerDialog.show();
            }
        });

        Timer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        AddTasksActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1hour2 = hourOfDay;
                                t1minute2 = minute;

                                String time = t1hour2 + ":" + t1minute2;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    Timer2.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },12,0,false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t1hour2,t1minute2);
                timePickerDialog.show();
            }
        });

    }

    public void createButtonPressed(View view) {
        String taskName = taskNameEditText.getText().toString();
        String startTime = startTimeEditText.getText().toString();
        String endTime = endTimeEditText.getText().toString();

        taskNameEditText.setText("");
        startTimeEditText.setText("");
        endTimeEditText.setText("");
        System.out.print(taskName);
        Task postMessage = new Task(taskName, startTime, endTime);
        databasePosts.push().setValue(postMessage);

        Intent intent = new Intent(this, SchedulePageActivity.class);

        intent.putExtra("taskName", taskName);
        intent.putExtra("startTime", startTime);
        intent.putExtra("endTime", endTime);

        startActivity(intent);
    }

    public void goHome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void goTask(View view){
        Intent intent = new Intent(this, SchedulePageActivity.class);
        startActivity(intent);
    }
    public void goAddTask(View view){
        Intent intent = new Intent(this, AddTasksActivity.class);
        startActivity(intent);
    }
}