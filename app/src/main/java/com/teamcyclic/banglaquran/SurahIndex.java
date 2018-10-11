package com.teamcyclic.banglaquran;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurahIndex extends Activity {
    ListView surahList;
    private static ArrayAdapter arrayAdapter;
    String [] quranIndex;
    ArrayList<String> listOfAllSurah;
    StringBuilder stringBuilder;
    //
    private final String forAdapter="SurahIndex";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_index);

        //getting database from arrys of string...
        quranIndex=getResources().getStringArray(R.array.indexQuran);
        listOfAllSurah= new ArrayList(Arrays.asList(quranIndex));
        stringBuilder=new StringBuilder(quranIndex[1]);
        String[] s=stringBuilder.toString().split("#");
        for (String s1: s)
            Log.d("krz",s1);


        AdapterForIndex adapter= new AdapterForIndex(getApplicationContext(),listOfAllSurah,forAdapter);
        surahList= (ListView) findViewById(R.id.listViewSurahName);

       // surahList.setAdapter(myArrayAdapter);
        surahList.setAdapter(adapter);
        surahList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(SurahIndex.this,SurahPage.class);

                startActivity(intent);


            }
        });



    }
}
