package com.github.crazyuploader.covid19.ui.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import com.github.crazyuploader.covid19.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapsOverview#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapsOverview extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    WebView mapsOverview;
    public MapsOverview() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapsOverview.
     */
    public static MapsOverview newInstance(String param1, String param2) {
        MapsOverview fragment = new MapsOverview();
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
        View view = inflater.inflate(R.layout.fragment_maps_overview, container, false);
        mapsOverview = view.findViewById(R.id.mapsOverview);
        mapsOverview.loadUrl("https://bing.com/covid");
        WebSettings webSettings = mapsOverview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mapsOverview.setWebViewClient(new WebViewClient());
        /*
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (nightModeFlags == Configuration.UI_MODE_NIGHT_YES) {
            webSettings.setForceDark(WebSettings.FORCE_DARK_ON);
        }
        */
        return view;
    }
}