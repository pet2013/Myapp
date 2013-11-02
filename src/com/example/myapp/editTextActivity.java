package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 02.11.13
 * Time: 10:42
 */
public class editTextActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext_activity);
        View backButton1 = findViewById(R.id.fourthBackButton);

        backButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}