package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Random;

public class ActiviChosse extends AppCompatActivity {
    ImageView adu, xoay;
    ConstraintLayout layout;
    Button button_thuthach,button_noithat,button1,button2,button3,button4,button5,button6;
    static String[] noidung = {"hát một bài","trò hề","đăng story","đăng fb","ăn","uống","gọi điện","tình cảm","thêm lượt","mất 10k","điện thoại","hành động"};

    static int[] position_goc = {30,60,80,110,140,170,200,230,260,280,310,340};
    int from;
    Dialog dialog;
    static String[] noithat_noidung = {"Ai","Kể","Đã Làm","Cái gì"};
    static int[] noithat_position = {0,90,180,270};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activi_chosse);
        adu = findViewById(R.id.ahihi);
        Glide.with(this).asGif().load(R.drawable.towmoon).into(adu);
        button_thuthach = findViewById(R.id.button_thuthach);
        button_noithat = findViewById(R.id.button_noithat);
        xoay = findViewById(R.id.imageView_hinhxoay);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha_button);
        button_thuthach.setAnimation(animation);
        button_noithat.setAnimation(animation);
        dialog = new Dialog(this);
        layout = findViewById(R.id.layout_xoay);
        layout.setVisibility(View.GONE);


        button_thuthach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoay.setImageResource(R.drawable.hahaha);
                Animation hieuung = AnimationUtils.loadAnimation(ActiviChosse.this,R.anim.hieuungxoay);
                xoay.startAnimation(hieuung);
                Random random = new Random();
                int position = random.nextInt(position_goc.length);
                int to = position_goc[position];
                if(from >= 360){
                    from -= 360;
                }
                Animation animation1 = AnimationUtils.loadAnimation(ActiviChosse.this,R.anim.hieuungxoay);
                layout.setVisibility(View.VISIBLE);
                layout.setAnimation(animation1);
                RotateAnimation rotateAnimation  = new RotateAnimation(from,to+(360*10),Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(5000);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String context = noidung[position];
                        Toast.makeText(ActiviChosse.this, context, Toast.LENGTH_SHORT).show();
                        from += to;
                        String noidung = "";
                        if(context.equals("hát một bài")){
                            noidung = laynoidung(R.array.hat);
                        }
                        if(context.equals("trò hề")){
                            noidung = laynoidung(R.array.tro);
                        }if(context.equals("đăng story")){
                            noidung = laynoidung(R.array.story);
                        }if(context.equals("đăng fb")){
                            noidung = laynoidung(R.array.fb);
                        }if(context.equals("ăn")){
                            noidung = laynoidung(R.array.an);
                        }if(context.equals("uống")){
                            noidung = laynoidung(R.array.uong);
                        }if(context.equals("gọi điện")){
                            noidung = laynoidung(R.array.goi);
                        }if(context.equals("tình cảm")){
                            noidung = laynoidung(R.array.tinh);
                        }if(context.equals("thêm lượt")){
                            noidung = laynoidung(R.array.them);
                        }if(context.equals("mất 10k")){
                            noidung = laynoidung(R.array.mat);
                        }if(context.equals("điện thoại")){
                            noidung = laynoidung(R.array.dien);
                        }if(context.equals("hành động")){
                            noidung = laynoidung(R.array.hanh);
                        }

                        dialog.setContentView(R.layout.showss);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                        TextView textViewshows = dialog.findViewById(R.id.textView_shows);
                        ImageView imageViewshows = dialog.findViewById(R.id.imageView_shows);
                        ImageView imageViewthoat = dialog.findViewById(R.id.imageView_show);
                        Glide.with(ActiviChosse.this).asGif().load(R.drawable.hai).into(imageViewshows);
                        textViewshows.setText(noidung);
                        imageViewthoat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                dialog.show();
                            }
                        };
                        new Handler().postDelayed(runnable, 2000);
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });

                xoay.startAnimation(rotateAnimation);
            }
        });
        button_noithat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoay.setImageResource(R.drawable.anhchuan);
                Animation animation2 = AnimationUtils.loadAnimation(ActiviChosse.this,R.anim.hieuungkhac);
                xoay.startAnimation(animation2);
                Random random = new Random();
                int position = random.nextInt(noithat_position.length);
                int to = noithat_position[position];
                if(from >= 360){
                    from -= 360;
                }
                Animation animation1 = AnimationUtils.loadAnimation(ActiviChosse.this,R.anim.hieuungkhac);
                layout.setVisibility(View.VISIBLE);
                layout.setAnimation(animation1);
                RotateAnimation rotateAnimation  = new RotateAnimation(from,to+(360*10),Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(5000);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String context = noithat_noidung[position];
                        Toast.makeText(ActiviChosse.this, context, Toast.LENGTH_SHORT).show();
                        from += to;
                        String noidung = "";
                        if(context.equals("Đã Làm")){
                            noidung = laynoidung(R.array.dalam);
                        }
                        if(context.equals("Cái gì")){
                            noidung = laynoidung(R.array.caigi);
                        }if(context.equals("Ai")){
                            noidung = laynoidung(R.array.ai);
                        }
                        if(context.equals("Kể")){
                            noidung = laynoidung(R.array.ke);
                        }

                        dialog.setContentView(R.layout.showss);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                        TextView textViewshows = dialog.findViewById(R.id.textView_shows);
                        ImageView imageViewshows = dialog.findViewById(R.id.imageView_shows);
                        ImageView imageViewthoat = dialog.findViewById(R.id.imageView_show);
                        Glide.with(ActiviChosse.this).asGif().load(R.drawable.hai).into(imageViewshows);
                        textViewshows.setText(noidung);
                        imageViewthoat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
//
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                dialog.show();
                            }
                        };
                        new Handler().postDelayed(runnable, 2000);
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                xoay.startAnimation(rotateAnimation);
            }
        });
    }
    protected String laynoidung(int x){
        Resources rs = getResources();
        String[] arr = rs.getStringArray(x);
        Random rd = new Random();
        int inde = rd.nextInt(arr.length);
        String information = arr[inde];
        return information;
    }
}