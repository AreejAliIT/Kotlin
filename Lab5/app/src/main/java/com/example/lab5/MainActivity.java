package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button send;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button)findViewById(R.id.button);
        send.setOnClickListener(new handleButton());
    }

    class handleButton implements View.OnClickListener {

        public void onClick(View view) {
            webView = (WebView) findViewById(R.id.web);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://googel.com");

            WebSettings webSetting = webView.getSettings();
            webSetting.setJavaScriptEnabled(true);
        }
    }
}