package com.github.crazyuploader.covid19.ui;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.github.crazyuploader.covid19.R;
import com.github.crazyuploader.covid19.ui.frags.AboutMe;
import com.github.crazyuploader.covid19.ui.frags.IndianStates;
import com.github.crazyuploader.covid19.ui.frags.MapsOverview;
import com.github.crazyuploader.covid19.ui.frags.WorldOverview;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_overview);

    }


    WorldOverview worldOverview = new WorldOverview();
    IndianStates indianStates = new IndianStates();
    AboutMe about = new AboutMe();
    MapsOverview mapsOverview = new MapsOverview();
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.navigation_overview) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.mainContainer, worldOverview).commit();
        }
        else if (item.getItemId() == R.id.navigation_india) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.mainContainer, indianStates).commit();
        }
        else if (item.getItemId() == R.id.navigation_map) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.mainContainer, mapsOverview).commit();
        }
        else
        {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.mainContainer, about).commit();
        }

        return true;
    }
}
