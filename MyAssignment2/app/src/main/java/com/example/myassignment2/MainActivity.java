package com.example.myassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insertBtn =(Button) findViewById(R.id.button2);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Insert(view);
            }
        });
        Button viewBtn =(Button) findViewById(R.id.button);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View(view);
            }
        });
    }
    public void Insert(View view) {
        startActivity(new Intent(getApplication(), InsertActivity.class));
      }
    public void View (View view) {
        startActivity(new Intent(getApplication(), ShowActivity.class));
    }
}