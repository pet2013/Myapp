package com.example.myapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        View button1 = findViewById(R.id.button1);
        View button2 = findViewById(R.id.button2);
        View button3 = findViewById(R.id.button3);
        View button4 = findViewById(R.id.button4);
        View webViewButton = findViewById(R.id.webViewButton);
        View radioImageButton = findViewById(R.id.radioImageButton);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        webViewButton.setOnClickListener(this);
        radioImageButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button1 :
                startActivity(new Intent(MainActivity.this, visibilityActivity.class));
                break;
            case R.id.button2 :
                startActivity(new Intent(MainActivity.this, spinnerScaleTypeActivity.class));
                break;
            case R.id.button3 :
                startActivity(new Intent(MainActivity.this, fontsActivity.class));
                break;
            case R.id.button4 :
                startActivity(new Intent(MainActivity.this, editTextActivity.class));
                break;
            case R.id.webViewButton :
                startActivity(new Intent(MainActivity.this, webViewActivity.class));
                break;
            case R.id.radioImageButton :
                startActivity(new Intent(MainActivity.this, radioScaleTypeActivity.class));
                break;
        }
    }
}
