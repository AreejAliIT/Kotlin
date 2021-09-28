package com.example.assignment;

//import android.provider.AlarmClock.EXTRA_MESSAGE;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private View view;

    public static final String EXTRA_MESSAGE="com.example.Lab3.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // findViewById(R.id.button).setOnClickListener(new handleButton());
    }


    public void SendMassge(View view){
        Intent i =new Intent(this,MainActivity2.class);
        EditText editText =(EditText) findViewById(R.id.editTextTextPersonName);
        String message=editText.getText().toString();
        i.putExtra(EXTRA_MESSAGE,message);
        startActivity(i);
    }
}