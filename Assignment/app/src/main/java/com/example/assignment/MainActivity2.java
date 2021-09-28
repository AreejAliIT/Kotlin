package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        String message =intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView=findViewById(R.id.textView);
        textView.setText(message);
    }


}