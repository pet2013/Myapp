package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class spinnerScaleTypeActivity extends Activity implements AdapterView.OnItemSelectedListener{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_st_activity);
        View backButton2 = findViewById(R.id.secondBackButton);
        Spinner spinner = (Spinner) findViewById(R.id.A2_spinner);

        backButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<String> list = new ArrayList<String>();

        for(Object s : ImageView.ScaleType.values()){
            list.add(s.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ImageView im = (ImageView) findViewById(R.id.A2_imageView);

        String st = (String) parent.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(),"ScaleType = "+st+".",Toast.LENGTH_LONG).show();

        im.setScaleType(ImageView.ScaleType.valueOf(st));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
    }
}