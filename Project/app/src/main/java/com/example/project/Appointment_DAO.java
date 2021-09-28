package com.example.project;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
@Dao
public interface Appointment_DAO {
    @Insert
    void insertAll(Appointment Appointment);

    @Query("select * from Appointment_Table")
    List<Appointment> getAll();

        @Query("Delete from Appointment_Table")
    void DeleteAll();
}
