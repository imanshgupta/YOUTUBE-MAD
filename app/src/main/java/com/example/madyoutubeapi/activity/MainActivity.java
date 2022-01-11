package com.example.madyoutubeapi.activity;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}