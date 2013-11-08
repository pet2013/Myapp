package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class listViewActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        View backButton = findViewById(R.id.AlistView_backButton);
        ListView listView = (ListView) findViewById(R.id.AlistView_listView);

        backButton.setOnClickListener(this);
        listView.setOnItemClickListener(this);

        ArrayList<String> list = new ArrayList<String>();

        for(Object s : ImageView.ScaleType.values()){
            list.add(s.toString());
        }
        for(Object s : ImageView.ScaleType.values()){
            list.add(s.toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.AlistView_backButton :
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String st = (String) parent.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(), "Item string = " + st + ".", Toast.LENGTH_LONG).show();
    }
}