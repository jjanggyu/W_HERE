package com.cau.where;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cau.where.navigation.AddFragment;
import com.cau.where.navigation.BoardFragment;
import com.cau.where.navigation.HomeFragment;
import com.cau.where.navigation.MypageFragment;
import com.cau.where.navigation.NotificationFragment;
import com.cau.where.navigation.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import android.os.Handler;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchFragment adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;

    public MainActivity(List<String> list) {
        this.list = list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setOnNavigationItemSelectedListener(this);
        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);

        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 검색에 사용할 데이터을 미리 저장한다.
        settingList();

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchFragment(list, this);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });
    }

    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }


    public boolean onNavigationItemSelected(@NotNull MenuItem p0) {
        switch(p0.getItemId()) {
            case R.id.action_home:
                HomeFragment homeFragment = new HomeFragment();
                this.getSupportFragmentManager().beginTransaction().replace(R.id.main_content, (Fragment)homeFragment).commit();
                return true;
            case R.id.action_board:
                BoardFragment boardFragment = new BoardFragment();
                this.getSupportFragmentManager().beginTransaction().replace(R.id.main_content, (Fragment)boardFragment).commit();
                return true;
            case R.id.action_add_photo:
                AddFragment addFragment = new AddFragment();
                this.getSupportFragmentManager().beginTransaction().replace(R.id.main_content, (Fragment)addFragment).commit();
                return true;
            case R.id.action_notification:
                NotificationFragment notificationFragment = new NotificationFragment();
                this.getSupportFragmentManager().beginTransaction().replace(R.id.main_content, (Fragment)notificationFragment).commit();
                return true;
            case R.id.action_account:
                MypageFragment mypageFragment = new MypageFragment();
                this.getSupportFragmentManager().beginTransaction().replace(R.id.main_content, (Fragment)mypageFragment).commit();
                return true;
            default:
                return false;
        }
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        list.add("채수빈");
        list.add("박지현");
        list.add("수지");
        list.add("남태현");
        list.add("하성운");
        list.add("크리스탈");
        list.add("강승윤");
        list.add("손나은");
        list.add("남주혁");
        list.add("루이");
        list.add("진영");
        list.add("슬기");
        list.add("이해인");
        list.add("고원희");
        list.add("설리");
        list.add("공명");
        list.add("김예림");
        list.add("혜리");
        list.add("웬디");
        list.add("박혜수");
        list.add("카이");
        list.add("진세연");
        list.add("동호");
        list.add("박세완");
        list.add("도희");
        list.add("창모");
        list.add("허영지");
    }

}
