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

public class NamePage extends Activity {
    ListView listViewAllahNames;
    private String[] getNamedatabase;
    private ArrayList<String> infoAllahNames;
    private final String forAdapter="NameIndex";

    private static AdapterForIndex arrayadapterNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_page);
         getNamedatabase=getResources().getStringArray(R.array.listOfNames);
         infoAllahNames=new ArrayList(Arrays.asList(getNamedatabase));
         //Log.d("krz",infoAllahNames.toString());

        arrayadapterNames= new AdapterForIndex(getApplicationContext(),infoAllahNames,forAdapter);
        listViewAllahNames= (ListView) findViewById(R.id.listAllahName_n);

        listViewAllahNames.setAdapter(arrayadapterNames);

    }
}
