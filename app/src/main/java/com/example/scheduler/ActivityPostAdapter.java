package com.example.scheduler;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ActivityPostAdapter extends ArrayAdapter<ActivityPosts> {
    public ActivityPostAdapter(Context context, ArrayList<ActivityPosts> list) {
        super(context, 0, list);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return convertView;
    }
}
