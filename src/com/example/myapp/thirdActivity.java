package com.example.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class thirdActivity extends Activity implements View.OnClickListener{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        View backButton3 = findViewById(R.id.thirdBackButton);

        View buttonSetGreen = findViewById(R.id.buttonSetGreen);
        View buttonSetRed = findViewById(R.id.buttonSetRed);
        View buttonSetBlue = findViewById(R.id.buttonSetBlue);

        View buttonFontSizeLess = findViewById(R.id.buttonFontSizeLess);
        View buttonFontSizeMore = findViewById(R.id.buttonFontSizeMore);

        buttonSetGreen.setOnClickListener(this);
        buttonSetRed.setOnClickListener(this);
        buttonSetBlue.setOnClickListener(this);
        backButton3.setOnClickListener(this);
        buttonFontSizeLess.setOnClickListener(this);
        buttonFontSizeMore.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        TextView label = (TextView)findViewById(R.id.A3_textView);
        switch (view.getId())
        {
            case R.id.buttonSetGreen :
                label.setTextColor(Color.GREEN);
                break;
            case R.id.buttonSetRed :
                label.setTextColor(Color.RED);
                break;
            case R.id.buttonSetBlue :
                label.setTextColor(Color.BLUE);
                break;
            case R.id.buttonFontSizeLess :
                label.setTextSize(TypedValue.COMPLEX_UNIT_SP, label.getTextSize() /getResources().getDisplayMetrics().scaledDensity - 5);
                break;
            case R.id.buttonFontSizeMore :
                label.setTextSize(TypedValue.COMPLEX_UNIT_SP, label.getTextSize() /getResources().getDisplayMetrics().scaledDensity +5);
                break;
            case R.id.thirdBackButton :
                finish();
                break;
        }
    }
}