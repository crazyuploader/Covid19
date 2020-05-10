package com.github.crazyuploader.covid19.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.github.crazyuploader.covid19.R;
import com.github.crazyuploader.covid19.globalData.Data;
import com.github.crazyuploader.covid19.misc.Format;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CountryDetails extends AppCompatActivity {

    ImageView countryFlag;
    TextView tvcountryName, countryTotalCases, countryTotalDeaths, countryTodayCases, countryTodayDeaths, countryRecovered;
    TextView countryActiveCases, countryCriticalCases, countryCasesPerMillion, countryDeathsPerMillion, countryTests, countryTestsPerMillion;
    Data fetched;
    TextView tvLastUpdated;
    String countryName, countryToFetch;
    ProgressBar frag_progressBar;
    LinearLayout countryDataHolder;
    long lastUpdated;
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
        tvLastUpdated = findViewById(R.id.tvLastUpdated);
        frag_progressBar = findViewById(R.id.frag_progressBar);
        countryDataHolder = findViewById(R.id.countryDataHolder);

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

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                fetched = gson.fromJson(response, Data.class);
                Glide.with(CountryDetails.this).load(fetched.getCountryInfo().getFlag()).into(countryFlag);
                countryTotalCases.setText(Format.number(fetched.getCases()));
                countryTodayCases.setText(Format.number(fetched.getTodayCases()));
                countryTotalDeaths.setText(Format.number(fetched.getDeaths()));
                countryTodayDeaths.setText(Format.number(fetched.getTodayDeaths()));
                countryRecovered.setText(Format.number(fetched.getRecovered()));
                countryActiveCases.setText(Format.number(fetched.getActive()));
                countryCriticalCases.setText(Format.number(fetched.getCritical()));
                countryCasesPerMillion.setText(Format.number(fetched.getCasesPerOneMillion()));
                countryDeathsPerMillion.setText(Format.number(fetched.getDeathsPerOneMillion()));
                countryTests.setText(Format.number(fetched.getTests()));
                countryTestsPerMillion.setText(Format.number(fetched.getTestsPerOneMillion()));
                lastUpdated = fetched.getUpdated();
                tvLastUpdated.setText(Format.date(lastUpdated));
                frag_progressBar.setVisibility(View.GONE);
                countryDataHolder.setVisibility(View.VISIBLE);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("URL Error", "Country Data could not be fetched");
            }
        });

        requestQueue.add(stringRequest);
    }

}
