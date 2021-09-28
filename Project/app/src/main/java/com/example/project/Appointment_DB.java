package com.example.project;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Appointment.class} , version = 2 , exportSchema = false)
public abstract class Appointment_DB extends RoomDatabase {

    public abstract Appointment_DAO Appointment_DAO();
}
