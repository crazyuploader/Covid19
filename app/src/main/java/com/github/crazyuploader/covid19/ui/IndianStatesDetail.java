package com.github.crazyuploader.covid19.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
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
import com.github.crazyuploader.covid19.indianStates.IndianStatesData;
import com.github.crazyuploader.covid19.indianStates.adapter.IndianStatesDataAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IndianStatesDetail extends AppCompatActivity {

    ProgressBar stateProgressBar;
    RecyclerView indianStateRecyclerView;
    final String indianStatesURL =
            "https://api.rootnet.in/covid19-in/stats/latest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_states_detail);

        stateProgressBar = findViewById(R.id.stateProgressBar);
        indianStateRecyclerView = findViewById(R.id.indianStateRecyclerView);
        indianStateRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, indianStatesURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONObject data = object.getJSONObject("data");
                            JSONArray regional = data.getJSONArray("regional");
                            GsonBuilder gsonBuilder = new GsonBuilder();
                            Gson gson = gsonBuilder.create();
                            IndianStatesData[] stateData = gson.fromJson(
                                    String.valueOf(regional), IndianStatesData[].class);
                            stateProgressBar.setVisibility(View.GONE);
                            indianStateRecyclerView.setAdapter(
                                    new IndianStatesDataAdapter(stateData));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Fetch Error", "Couldn't fetch Indian States Data");
                    }
                });

        requestQueue.add(stringRequest);
    }
}
