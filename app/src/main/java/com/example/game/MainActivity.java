package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.service.voice.VoiceInteractionSession;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    RelativeLayout layoutBackgrout;
    ImageView  ImageView_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutBackgrout = findViewById(R.id.layoutLogo);
        ImageView_logo = findViewById(R.id.logo);
        Animation animation_alfa = AnimationUtils.loadAnimation(this,R.anim.alpha_start);
        layoutBackgrout.setAnimation(animation_alfa);
        Animation animation_scale = AnimationUtils.loadAnimation(this,R.anim.scale_start);
        ImageView_logo.setAnimation(animation_scale);
        animation_scale.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, ActiviChosse.class));
                finish();
            }
        },3000);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}