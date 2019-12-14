package com.jasjotsingh.androidonboardinghopanimation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout linearLayoutBottomSheet;
    private Handler animationHandler;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutBottomSheet = findViewById(R.id.linearLayoutBottomSheet);
        textView = findViewById(R.id.textview);
        animationHandler = new Handler();

        animationHandler.post(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void run() {

                ViewPropertyAnimator viewPropertyAnimator =
                        linearLayoutBottomSheet.animate().translationYBy(-40f).setDuration(200);

                viewPropertyAnimator.withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        linearLayoutBottomSheet.animate().translationYBy(40f).setDuration(200);
                    }
                });

                animationHandler.postDelayed(this, 1000);

            }
        });


    }
}
