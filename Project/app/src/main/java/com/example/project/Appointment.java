package com.example.project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity (tableName = "Appointment_Table")
public class Appointment {

    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo(name="Date")
    private String Date;
    @ColumnInfo(name="Hospital \\ Clinic")
    private String Hospital;
    @ColumnInfo(name="Dr_Name")
    private String  Dr_Name;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDate() { return Date; }
    public void setDate(String Date) { this.Date = Date; }

    public String getHospital() { return Hospital; }
    public void setHospital(String Hospital) { this.Hospital = Hospital; }

    public String getDr_Name() { return Dr_Name; }
    public void setDr_Name(String Dr_Name) { this.Dr_Name = Dr_Name; }
}




