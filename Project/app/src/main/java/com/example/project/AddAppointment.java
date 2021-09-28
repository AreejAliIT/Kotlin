package com.example.project;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
public class AddAppointment extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        Spinner spinner =(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.menu , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        Button insert =(Button)findViewById(R.id.button3);
        insert.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                insert(view);
            }
        });
    }
    public void insert(View view) {
        Appointment_DB DB = Room.databaseBuilder(this, Appointment_DB.class, "Appointment_Table")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        EditText date = (EditText) findViewById(R.id.date);
        EditText hospital = (EditText) findViewById(R.id.Hospital);
        EditText drname = (EditText) findViewById(R.id.dr_name);
        Appointment_DAO dao = DB.Appointment_DAO();
        Appointment B = new Appointment();
        String InsertDate = date.getText().toString();
        String InsertHospital = hospital.getText().toString();
        String InsertDrName = drname.getText().toString();

        B.setDate(InsertDate);
        B.setHospital(InsertHospital);
        B.setDr_Name(InsertDrName);
        dao.insertAll(B);

        Message.message(getApplicationContext(), "Insertion Successfully . ");

        date.setText("");
        hospital.setText("");
        drname.setText("");
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