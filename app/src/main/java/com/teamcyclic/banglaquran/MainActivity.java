package com.teamcyclic.banglaquran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imgbtn_startReading;
    private ImageView imgbtn_Names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.my);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(MainActivity.this, SurahIndex.class);
        final Intent intent2 = new Intent(MainActivity.this, NamePage.class);

        imgbtn_startReading = (ImageView) findViewById(R.id.imgbtn_startReading);
        imgbtn_startReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        imgbtn_Names = (ImageView) findViewById(R.id.imgbtn_Allahnames);
        imgbtn_Names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        ///////////////
        String[] quranIndex = getResources().getStringArray(R.array.listOfNames);
        StringBuilder stringBuilder = new StringBuilder(quranIndex[65]);
        String[] s = stringBuilder.toString().split("@");
        for (String s1: s)
            Log.d("krz",s1);

    }
}