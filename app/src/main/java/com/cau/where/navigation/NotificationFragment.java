package com.cau.where.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cau.where.R;

public class NotificationFragment extends Fragment {
    TextView textView1, textView2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification,container,false);
        getChildFragmentManager().beginTransaction().add(R.id.alarm_fragment, new NotificationAlarm()).commit();
        textView1 = (TextView) view.findViewById(R.id.notification_alarm);
        textView2 = (TextView) view.findViewById(R.id.notification_text);


        textView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.alarm_fragment, new NotificationAlarm()).commit();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.alarm_fragment, new NotificationText()).commit();
            }
        });


        return view;
    }
}
