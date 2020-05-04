package com.example.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    RecyclerView countryView;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menuRefresh:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.menuSearch:
                Toast.makeText(this, "Uh-Huh, WIP!", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    final String baseURL = "https://corona.lmao.ninja/v2/countries";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryView = findViewById(R.id.countryView);
        countryView.setLayoutManager(new LinearLayoutManager(this));

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        final Toast if_fetch_error = Toast.makeText(this, "Opps, anomalies detected, WIP bye!", Toast.LENGTH_LONG);
        final Toast if_input_empty = Toast.makeText(this, "Please enter something as country name can't be empty, please try again!", Toast.LENGTH_LONG);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, baseURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Data[] data = gson.fromJson(response, Data[].class);
                countryView.setAdapter(new DataAdapter(MainActivity.this, data));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if_fetch_error.show();
            }
        });

        requestQueue.add(stringRequest);
    }
}
