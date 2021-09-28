package com.example.assigenment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void InsertAll (View view) {
     startActivity(new Intent(getApplication(), ShowActivity.class));
    }
    public void Update (View view) {
        startActivity(new Intent(getApplication(), UpdateActivity.class));
    }
    public void InsertAll (View view) {
        startActivity(new Intent(getApplication(), ShowActivity.class));
    }
}