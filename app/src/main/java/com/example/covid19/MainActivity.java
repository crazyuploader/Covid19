package com.example.covid19;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    EditText etCountry;
    Button btnFetch;
    TextView tvCountry, tvCases, tvTotalCases, tvDeaths, tvTotalDeaths;
    String baseURL = "https://corona.lmao.ninja/v2/countries/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCountry = findViewById(R.id.etCountry);
        btnFetch = findViewById(R.id.btnFetch);
        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvTotalCases = findViewById(R.id.tvTotalCases);
        tvDeaths = findViewById(R.id.tvDeaths);
        tvTotalDeaths = findViewById(R.id.tvTotalCases);

        etCountry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                etCountry.setHint("");
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCountry.setVisibility(View.GONE);
                btnFetch.setVisibility(View.GONE);
            }
        });

    }
}
