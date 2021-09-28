package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.webkit.*;
import android.widget.Button;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                WebView myWebView = (WebView) findViewById(R.id.webview);
                myWebView.setWebViewClient(new WebViewClient());
//                String s="https://google.com";com
                myWebView.loadUrl("https://developer.android.com/studio/intro/migrate");
                WebSettings WebSettings= myWebView.getSettings();
                WebSettings.setJavaScriptEnabled(true);

            }

        });



}
}