package com.example.myapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class webViewActivity extends Activity implements View.OnClickListener{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        View backButton = findViewById(R.id.backButton);
        View goButton = findViewById(R.id.WebView_goButton);
        View putUrlButton = findViewById(R.id.WebView_putUrl);

        backButton.setOnClickListener(this);
        goButton.setOnClickListener(this);
        putUrlButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final String URL = "http://www.google.com/";

        final EditText textInput = (EditText) findViewById(R.id.WebView_UrlInput);
        WebView wv = (WebView) findViewById(R.id.WebView_view);
        final ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);

        switch (view.getId())
        {
            case R.id.WebView_goButton :
                wv.setWebViewClient(new WebViewClient(){
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon){
                        pb.setVisibility(View.VISIBLE);
                        textInput.setText(url);
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
                break;
            case R.id.WebView_putUrl :
                textInput.setText(URL);
                break;
            case R.id.backButton :
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView wv = (WebView) findViewById(R.id.WebView_view);
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
            wv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}