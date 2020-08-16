package com.example.scheduler;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(Context context, ArrayList<Task> list) {
        super(context, 0, list);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.a_list_item, parent, false);
        Task activityMsg = getItem(position);

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        titleTextView.setText(activityMsg.getTitle());

        TextView startTimeView = convertView.findViewById(R.id.startTextView);
        startTimeView.setText(activityMsg.getStartTime() + " - " + activityMsg.getEndTime());

        return convertView;
    }



}
