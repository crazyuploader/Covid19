package com.example.covid19;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText etCountry;
    Button btnFetch;
    TextView tvFetched;
    final String baseURL = "https://corona.lmao.ninja/v2/countries/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCountry = findViewById(R.id.etCountry);
        btnFetch = findViewById(R.id.btnFetch);
        tvFetched = findViewById(R.id.tvFetched);

        etCountry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                etCountry.setHint("");
            }
        });

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        final Toast if_fetch_error = Toast.makeText(this, "Opps, anomalies detected, WIP bye!", Toast.LENGTH_LONG);
        final Toast if_input_empty = Toast.makeText(this, "Please enter something as country name can't be empty, please try again!", Toast.LENGTH_LONG);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = etCountry.getText().toString().trim();

                if (input.length() != 0)
                {
                    etCountry.setVisibility(View.GONE);
                    btnFetch.setVisibility(View.GONE);
                    String fetchURL = baseURL + input;
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, fetchURL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                tvFetched.setText("Country: " + jsonObject.getString("country") + "\n\n"
                                        + "Cases Today: " + jsonObject.getString("todayCases") + "\n\n"
                                        + "Total Cases: " + jsonObject.getString("cases") + "\n\n"
                                        + "Deaths Today: " + jsonObject.getString("todayDeaths") + "\n\n"
                                        + "Total Deaths: " + jsonObject.getString("deaths") + "\n\n"
                                        + "Recovered: " + jsonObject.getString("recovered") + "\n\n"
                                        + "Tests: " + jsonObject.getString("tests"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if_fetch_error.show();

                        }
                    });

                    requestQueue.add(stringRequest);
                }
                else
                {
                    if_input_empty.show();
                }
            }
        });

    }
}
