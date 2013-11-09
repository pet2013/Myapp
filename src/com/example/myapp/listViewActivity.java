package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class listViewActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{
    final int LIST_VIEW_MODE = 2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);
        View backButton = findViewById(R.id.AlistView_backButton);
        ListView listView = (ListView) findViewById(R.id.AlistView_listView);

        backButton.setOnClickListener(this);
        listView.setOnItemClickListener(this);

        // mode:
        // 0: string list
        // default: custom object list

        switch (LIST_VIEW_MODE){
            case 0:
                ArrayList<String> stringList = new ArrayList<String>();

                for(Object s : ImageView.ScaleType.values()){
                    stringList.add(s.toString());
                }
                for(Object s : ImageView.ScaleType.values()){
                    stringList.add(s.toString());
                }
                //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
                //listView.setAdapter(adapter);
                myListAdapter myStringAdapter = new myListAdapter(this, stringList);
                listView.setAdapter(myStringAdapter);
                break;
            default:
                ArrayList<DataObject> objectList = new ArrayList<DataObject>();
                int imageSrc;
                for(int i=0; i<20;i++){
                    if (i%2 == 1) {
                        imageSrc = R.drawable.test;
                    } else {
                        imageSrc = R.drawable.ic_launcher;
                    }
                    objectList.add(new DataObject("Item #"+(i+1),imageSrc));
                }

                NewListAdapter myObjectAdapter = new NewListAdapter(this, objectList);
                listView.setAdapter(myObjectAdapter);
                break;
        }
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
        switch (LIST_VIEW_MODE){
            case 0:
                String listString = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Mode = "+LIST_VIEW_MODE+" | Item string = " + listString + ".", Toast.LENGTH_LONG).show();
                break;
            default:
                DataObject listObject = (DataObject) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Mode = "+LIST_VIEW_MODE+" | Item string = " + listObject.getCaption() + ".", Toast.LENGTH_LONG).show();
                break;
        }
    }
}