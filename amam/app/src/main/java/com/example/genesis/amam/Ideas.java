package com.example.genesis.amam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Ideas extends AppCompatActivity {
    WebView wvTasty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas);
        wvTasty = (WebView)findViewById(R.id.wvTasty);
        wvTasty.loadUrl("https://tasty.co/");
        wvTasty.getSettings().setJavaScriptEnabled(true);
        wvTasty.setWebViewClient(new WebViewClient());
    }

}
