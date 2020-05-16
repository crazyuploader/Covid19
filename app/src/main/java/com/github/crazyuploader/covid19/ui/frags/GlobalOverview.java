package com.github.crazyuploader.covid19.ui.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
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
import com.github.crazyuploader.covid19.globalData.adapter.GlobalTempDataAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GlobalOverview#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GlobalOverview extends Fragment implements GlobalDataAdapter.onCountryClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ProgressBar progressBar;
    RecyclerView countryView;
    final String baseURL = "https://disease.sh/v2/countries?sort=cases";
    public GlobalOverview() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorldOverview.
     */
    public static GlobalOverview newInstance(String param1, String param2) {
        GlobalOverview fragment = new GlobalOverview();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_global_overview, container, false);

        countryView = view.findViewById(R.id.countryView);
        countryView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar = view.findViewById(R.id.progressbar);

        final RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, baseURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        Data[] data = gson.fromJson(response, Data[].class);
                        countryView.setAdapter(
                                new GlobalTempDataAdapter(data));
                        progressBar.setVisibility(View.GONE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                    }
                });

        requestQueue.add(stringRequest);

        return view;
    }

    @Override
    public void onCountryClick(CharSequence countryName) {

    }
}
