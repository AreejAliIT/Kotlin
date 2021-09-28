package com.example.assigenment;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Delete;
import androidx.room.Update;
import androidx.room.Query;
import java.util.List;

@Dao
public interface booking_DAO {

    @Insert
    void insertall(Booking booking);

    @Query("select * from Booking")
    List<Booking> getAll();

    @Update
    void update(Booking booking);

    @Query("Delete from Booking where Id=:id")
    void DeleteByID(int id);

    @Query("Delete from Booking")
    void DeleteAll();

}