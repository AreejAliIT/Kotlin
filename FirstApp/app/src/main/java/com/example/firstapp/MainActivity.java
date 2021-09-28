package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button send;
    EditText feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button)findViewById(R.id.Button);
        feedback=(EditText)findViewById(R.id.editText);
        send.setOnClickListener(new handleButton());
    }

    class handleButton implements View.OnClickListener {
        public void onClick(View view) {

            String to = "AreejAlbarqii@gmail.com";
            String subject = "FeedBack";
            String message = feedback.getText().toString();

            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
            email.putExtra(Intent.EXTRA_SUBJECT, subject);
            email.putExtra(Intent.EXTRA_TEXT, message);

            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "choose an Email Provider:"));
        }
    }
}