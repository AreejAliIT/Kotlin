package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class ViewAppointment extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
 TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointment);


        Spinner spinner =(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.menu , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Appointment_DB DB = Room.databaseBuilder(this,Appointment_DB.class, "Appointment_Table")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        Appointment_DAO dao= DB.Appointment_DAO();
        List<Appointment> BObj= dao.getAll();

        show =findViewById(R.id.textView);
        String info="";
        for(Appointment appointment : BObj ){
            String date = appointment.getDate();
            String hospital = appointment.getHospital();
            String dr_name = appointment.getDr_Name();
            info=info+"\n\n\n"+ "Date: "+date+"\n"+"Hospital \\ Clinic: "+hospital+"\n"+"Dr. Name: "+dr_name;
        }
        show.setText(info);
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