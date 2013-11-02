package com.example.myapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


public class webViewActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        View backButton = findViewById(R.id.backButton);
        View goButton = findViewById(R.id.WebView_goButton);
        View putUrlButton = findViewById(R.id.WebView_putUrl);
        final String URL = "http://www.google.com/";

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textInput = (EditText) findViewById(R.id.WebView_UrlInput);
                WebView wv = (WebView) findViewById(R.id.WebView_view);
                final ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
                wv.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon){
                        pb.setVisibility(View.VISIBLE);
                    }
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        pb.setVisibility(View.GONE);
                    }
                });
                if(TextUtils.isEmpty(textInput.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Введите URL.", Toast.LENGTH_LONG).show();
                }else{
                    wv.loadUrl(textInput.getText().toString());
                }

            }
        });

        putUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textInput = (EditText) findViewById(R.id.WebView_UrlInput);
                textInput.setText(URL);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}