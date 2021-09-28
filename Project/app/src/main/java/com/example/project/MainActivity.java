package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner =(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.menu , android.R.layout.simple_spinner_item);
                 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 spinner.setAdapter(adapter);
                 spinner.setOnItemSelectedListener(this);

     }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String input = parent.getItemAtPosition(position).toString();
        if(input.equals("Add")){
            startActivity(new Intent(getApplication(), AddAppointment.class));
        }else if(input.equals("View")) {
            startActivity(new Intent(getApplication(), ViewAppointment.class));
        }else if(input.equals("Home")) {
            startActivity(new Intent(getApplication(), MainActivity.class));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}