package com.cau.where;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cau.where.navigation.AddFragment;
import com.cau.where.navigation.BoardFragment;
import com.cau.where.navigation.HomeFragment;
import com.cau.where.navigation.MypageFragment;
import com.cau.where.navigation.NotificationFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setOnNavigationItemSelectedListener(this);
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

}
