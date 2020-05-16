package com.github.crazyuploader.covid19.ui.frags;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.crazyuploader.covid19.BuildConfig;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.github.crazyuploader.covid19.R;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

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

    final String version = BuildConfig.VERSION_NAME;
    final String githubURL = "https://crazyuploader.github.io/";
    final String description = "Reserved ~";
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
        Element versionElement = new Element();
        versionElement.setTitle("Version " + version);
        Element telegram = new Element();
        telegram.setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/choochiye")))
                .setTitle("Add me on Telegram")
                .setIconDrawable(R.drawable.ic_telegram);
        return new AboutPage(getContext())
                .isRTL(false)
                .setImage(R.drawable.ic_user)
                .setDescription(description)
                .addItem(versionElement)
                .addGroup("Connect with me")
                .addEmail("jugalkishor839@gmail.com", "Email")
                .addWebsite(githubURL, "Website")
                .addGitHub("crazyuploader", "Follow me on GitHub")
                .addInstagram("choochiye", "Follow me on Instagram")
                .addTwitter("choochiye", "Follow me on Twitter")
                .addItem(telegram)
                .create();
    }
}
