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
import com.github.crazyuploader.covid19.ui.frags.GlobalOverview;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class Main2Activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AppCenter.start(getApplication(), "00fd6ff5-6459-43e1-8d46-2a512b249a50",
                Analytics.class, Crashes.class);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_overview);

    }


    final GlobalOverview worldOverview = new GlobalOverview();
    final IndianStates indianStates = new IndianStates();
    final AboutMe about = new AboutMe();
    final MapsOverview mapsOverview = new MapsOverview();
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
