package com.github.crazyuploader.covid19.ui;

import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.crazyuploader.covid19.R;
import com.github.crazyuploader.covid19.indianStates.Regional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class IndianStatesDetail extends AppCompatActivity {

    TextView tvIndianStatesTest;
    String indianStatesURL = "https://api.rootnet.in/covid19-in/stats/latest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_states_detail);

        tvIndianStatesTest = findViewById(R.id.tvIndianStatesTest);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, indianStatesURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Regional indianStatesData = gson.fromJson(response, Regional.class);
                tvIndianStatesTest.setText(indianStatesData.getLoc());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Fetch Error", "Couldn't fetch Indian States Data");
            }
        });

        requestQueue.add(stringRequest);

    }
}
