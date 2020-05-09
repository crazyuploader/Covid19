package com.github.crazyuploader.covid19.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.crazyuploader.covid19.R;
import org.json.JSONException;
import org.json.JSONObject;

public class CountryDetails extends AppCompatActivity {

    ImageView countryFlag;
    TextView tvcountryName, countryTotalCases, countryTotalDeaths, countryTodayCases, countryTodayDeaths, countryRecovered;
    TextView countryActiveCases, countryCriticalCases, countryCasesPerMillion, countryDeathsPerMillion, countryTests, countryTestsPerMillion;
    String countryName, countryToFetch;
    final String countryDataLink = "https://disease.sh/v2/countries/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        tvcountryName = findViewById(R.id.frag_countryName);
        countryFlag = findViewById(R.id.frag_countryFlag);
        countryTotalCases = findViewById(R.id.frag_countryTotalCases);
        countryTotalDeaths = findViewById(R.id.frag_countryTotalDeaths);
        countryTodayCases = findViewById(R.id.frag_countryTodayCase);
        countryTodayDeaths = findViewById(R.id.frag_countryTodayDeaths);
        countryRecovered = findViewById(R.id.frag_countryRecovered);
        countryActiveCases = findViewById(R.id.frag_countryActiveCases);
        countryCriticalCases = findViewById(R.id.frag_countryCritical);
        countryCasesPerMillion = findViewById(R.id.frag_countryCasesPerMillion);
        countryDeathsPerMillion = findViewById(R.id.frag_countryDeathsPerMillion);
        countryTests = findViewById(R.id.frag_countryTests);
        countryTestsPerMillion = findViewById(R.id.frag_countryTestsPerMillion);

        countryName = getIntent().getStringExtra("Country");

        tvcountryName.setText(countryName);

        countryToFetch = countryDataLink + countryName;

        updateUI();

    }

    public void updateUI(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, countryToFetch, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject countryInfo = jsonObject.getJSONObject("countryInfo");
                    Glide.with(CountryDetails.this).load(countryInfo.getString("flag")).into(countryFlag);
                    countryTotalCases.setText(jsonObject.getString("cases"));
                    countryTodayCases.setText(jsonObject.getString("todayCases"));
                    countryTotalDeaths.setText(jsonObject.getString("deaths"));
                    countryTodayDeaths.setText(jsonObject.getString("todayDeaths"));
                    countryRecovered.setText(jsonObject.getString("recovered"));
                    countryActiveCases.setText(jsonObject.getString("active"));
                    countryCriticalCases.setText(jsonObject.getString("critical"));
                    countryCasesPerMillion.setText(jsonObject.getString("casesPerOneMillion"));
                    countryDeathsPerMillion.setText(jsonObject.getString("deathsPerOneMillion"));
                    countryTests.setText(jsonObject.getString("tests"));
                    countryTestsPerMillion.setText(jsonObject.getString("testsPerOneMillion"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("URL Error", "Country Data could not be fetched");
            }
        });

        requestQueue.add(stringRequest);
    };

}
