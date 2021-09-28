package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private View view;
    public static final String EXTRA_MESSAGE = "com.example.myapplication.MainActivity.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void SendMessage(View view){

            Intent i =new Intent(this,MainActivity2.class);

            EditText editText =(EditText) findViewById(R.id.editTextText1);

            String message=editText.getText().toString();

            i.putExtra(EXTRA_MESSAGE,message);

            startActivity(i);
        }
    }
