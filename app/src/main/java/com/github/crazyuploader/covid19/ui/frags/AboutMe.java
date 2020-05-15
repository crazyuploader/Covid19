package com.github.crazyuploader.covid19.ui.frags;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.crazyuploader.covid19.R;
import com.github.crazyuploader.covid19.misc.Custom_Toast;
import com.github.crazyuploader.covid19.ui.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutMe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutMe extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView footer;
    final String githubURL = "https://crazyuploader.github.io/";
    public AboutMe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutMe.
     */
    public static AboutMe newInstance(String param1, String param2) {
        AboutMe fragment = new AboutMe();
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
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        footer = view.findViewById(R.id.footer_main);
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(githubURL));
                startActivity(browserIntent);
                Custom_Toast.show(getActivity(), "Following me around?", 0);
            }
        });

        return view;
    }
}
