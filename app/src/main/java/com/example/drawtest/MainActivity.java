package com.example.drawtest;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void goDraw(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,exampleDraw.class);
        startActivity(intent);

    }
    public  void goAnimation(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Animation.class);
        startActivity(intent);

    }
    public  void goSpread(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,exampleSpread.class);
        startActivity(intent);
    }

    public  void goByteDance(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,ByteDance.class);
        startActivity(intent);
    }
    public  void goBicycle(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Bicycle.class);
        startActivity(intent);
    }
    public  void goStartup(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Startup.class);
        startActivity(intent);
    }
    public  void goMenuSlide(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,MenuSlide.class);
        startActivity(intent);
    }

    public  void goMenu(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,MenuRB.class);
        startActivity(intent);
    }

    public  void goDazzle(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Dazzle.class);
        startActivity(intent);
    }








}
