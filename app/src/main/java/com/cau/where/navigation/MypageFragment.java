package com.cau.where.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cau.where.R;

public class MypageFragment extends Fragment {
    Button button1, button2, button3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage,container,false);
        getChildFragmentManager().beginTransaction().add(R.id.child_fragment, new MypageMywhere()).commit();
        button1 = (Button) view.findViewById(R.id.mypage_button1);
        button2 = (Button) view.findViewById(R.id.mypage_button2);
        button3 = (Button) view.findViewById(R.id.mypage_button3);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new MypageMywhere()).commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new MypageMypic()).commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new MypageScrap()).commit();
            }
        });


        return view;
    }
}
