package com.example.madyoutubeapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.madyoutubeapi.R;
import com.example.madyoutubeapi.fragment.HomeFragment;
import com.example.madyoutubeapi.fragment.PlaylistFragment;
import com.example.madyoutubeapi.fragment.ProfileFragment;
import com.example.madyoutubeapi.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment = new HomeFragment();
    private PlaylistFragment playlistFragment = new PlaylistFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private ProfileFragment profileFragment = new ProfileFragment();

    private BottomNavigationView menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu=findViewById(R.id.menu_bawah);

        setFragment(homeFragment);

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame,fragment);
        ft.commit();
    }

}