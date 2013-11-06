package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class radioScaleTypeActivity extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_st_activity);
        View backButton = findViewById(R.id.AradioST_backButton);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.AradioST_radioGroup);

        backButton.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        for(Object s : ImageView.ScaleType.values()){
            RadioButton rb = new RadioButton(this);
            rb.setText(s.toString());
            radioGroup.addView(rb);
        }
        RadioButton checkedRadio = (RadioButton) radioGroup.getChildAt(0);
        checkedRadio.setChecked(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.AradioST_backButton :
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ImageView im = (ImageView) findViewById(R.id.AradioST_imageView);
        RadioButton checkedRadio = (RadioButton) group.getChildAt(checkedId-1);

        String st = checkedRadio.getText().toString();
        Toast.makeText(getApplicationContext(), "ScaleType = " + st + ".", Toast.LENGTH_LONG).show();

        im.setScaleType(ImageView.ScaleType.valueOf(st));
    }
}