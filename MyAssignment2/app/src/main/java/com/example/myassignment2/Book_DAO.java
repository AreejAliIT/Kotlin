package com.example.myassignment2;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao

public interface Book_DAO {

    @Insert
    void insertAll(EBook EBook);

    @Query("select * from E_Book")
    List<EBook> getAll();

//    @Update
//    void update(EBook eBook);
//
//    @Query("Delete from E_Book where Id=:id")
//    void DeleteByID(int id);
//
//    @Query("Delete from E_Book")
//    void DeleteAll();
}
