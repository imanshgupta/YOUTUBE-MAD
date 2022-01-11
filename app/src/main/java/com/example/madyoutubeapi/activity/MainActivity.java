package com.example.madyoutubeapi.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.madyoutubeapi.R;
import com.example.madyoutubeapi.fragment.HomeFragment;
import com.example.madyoutubeapi.fragment.PlaylistFragment;
import com.example.madyoutubeapi.fragment.ProfileFragment;
import com.example.madyoutubeapi.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.isChecked()){
                    return true;
                }else{
                    //to get the current id of the navigator button pressed and then to choose that
                    //an alternate to the 3rd MAD program of fragments insetead of INTEGER variable
                    switch (item.getItemId()){
                        case R.id.menu_home:
                            setFragment(homeFragment);
                            getSupportActionBar().setTitle("HOME");
                            return true;
                        case R.id.menu_playlist:
                            setFragment(playlistFragment);
                            getSupportActionBar().setTitle("PLAYLIST");
                            return true;
                        case R.id.menu_search:
                            setFragment(searchFragment);
                            getSupportActionBar().setTitle("SEARCH");
                            return true;
                        case R.id.menu_profile:
                            setFragment(profileFragment);
                            getSupportActionBar().setTitle("PROFILE");
                            return true;
                        default:
                            setFragment(homeFragment);
                            getSupportActionBar().setTitle("HOME");
                           return true;
                    }
                }
            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame,fragment);
        ft.commit();
    }

}