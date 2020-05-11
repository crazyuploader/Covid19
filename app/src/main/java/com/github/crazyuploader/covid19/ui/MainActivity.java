package com.github.crazyuploader.covid19.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.crazyuploader.covid19.R;
import com.github.crazyuploader.covid19.globalData.Data;
import com.github.crazyuploader.covid19.globalData.adapter.GlobalDataAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity implements GlobalDataAdapter.onCountryClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    ProgressBar progressBar;
    RecyclerView countryView;
    TextView footer;
    final String githubURL = "https://crazyuploader.github.io/";
    final String baseURL = "https://disease.sh/v2/countries?sort=cases";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryView = findViewById(R.id.countryView);
        countryView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.progressbar);
        footer = findViewById(R.id.footer_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setSelectedItemId(R.id.navigation_overview);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        final Toast if_fetch_error = Toast.makeText(this, R.string.network_issue, Toast.LENGTH_LONG);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, baseURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Data[] data = gson.fromJson(response, Data[].class);
                countryView.setAdapter(new GlobalDataAdapter(data, MainActivity.this));
                progressBar.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if_fetch_error.show();
                progressBar.setVisibility(View.GONE);
            }
        });

        requestQueue.add(stringRequest);

        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubURL));
                startActivity(browserIntent);
                Custom_Toast.show(MainActivity.this, "Following me around?", 0);
            }
        });
    }

    @Override
    public void onCountryClick(CharSequence countryName) {
        Intent intent = new Intent(this, CountryDetails.class);
        intent.putExtra("Country", countryName);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.navigation_india:
                startActivity(new Intent(MainActivity.this, IndianStatesDetail.class));
        }
        return true;
    }
}
