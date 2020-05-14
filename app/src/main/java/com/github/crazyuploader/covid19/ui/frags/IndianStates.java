package com.github.crazyuploader.covid19.ui.frags;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IndianStates#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndianStates extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ProgressBar stateProgressBar;
    RecyclerView indianStateRecyclerView;
    final String indianStatesURL =
            "https://api.rootnet.in/covid19-in/stats/latest";
    public IndianStates() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndianStates.
     */
    // TODO: Rename and change types and number of parameters
    public static IndianStates newInstance(String param1, String param2) {
        IndianStates fragment = new IndianStates();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_indian_states, container, false);
        stateProgressBar = view.findViewById(R.id.stateProgressBar);
        indianStateRecyclerView = view.findViewById(R.id.indianStateRecyclerView);
        indianStateRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));

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

        return view;
    }
}
