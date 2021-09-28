package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    EditText feedback;

    ImageButton search;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         input = (EditText) findViewById(R.id.input);
         search = (ImageButton)findViewById(R.id.imageButton) ;
         search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String inputSearch =  input.getText().toString();
                Intent viewSearch = new Intent(Intent.ACTION_WEB_SEARCH);
                viewSearch.putExtra(SearchManager.QUERY , inputSearch);

                startActivity(viewSearch);
            }
        });
    }
}