package com.github.crazyuploader.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.crazyuploader.covid19.ui.Main2Activity;

public class SplashActivity extends AppCompatActivity {

    ImageView splashImageView;
    TextView splashTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashImageView = findViewById(R.id.splashImageView);
        splashTextView = findViewById(R.id.splashTextView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);
        splashImageView.startAnimation(animation);
        splashTextView.startAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }
}
