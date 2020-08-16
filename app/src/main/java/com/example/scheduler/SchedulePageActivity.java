package com.example.scheduler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SchedulePageActivity extends AppCompatActivity {
    TaskAdapter adapter;
    DatabaseReference databaseTasks;

    ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);
        ListView aView = findViewById(R.id.activity);


        //Create and Set Adapter
        adapter = new TaskAdapter(this, tasks);
        aView.setAdapter(adapter);

        //Reference Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseTasks = database.getReference().child("Tasks");

        databaseTasks.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Task task = dataSnapshot.getValue(Task.class);
                    tasks.add(task);
                    adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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