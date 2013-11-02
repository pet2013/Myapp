package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class firstActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        View backButton1 = findViewById(R.id.firstBackButton);
        RadioGroup rg = (RadioGroup) findViewById(R.id.A1_radioGroup);

        backButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView toChange = (TextView) findViewById(R.id.A1_toChange);
                TextView statusView = (TextView) findViewById(R.id.A1_textViewStatus);

                switch (group.getCheckedRadioButtonId()){
                    case R.id.radioButtonVisible:
                        toChange.setVisibility(View.VISIBLE);
                        statusView.setText("VISIBLE");
                        break;
                    case R.id.radioButtonInvisible:
                        toChange.setVisibility(View.INVISIBLE);
                        statusView.setText("INVISIBLE");
                        break;
                    case R.id.radioButtonGone:
                        toChange.setVisibility(View.GONE);
                        statusView.setText("GONE");
                        break;
                }
            }
        });
    }
}