package com.example.myassignment2;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EBook.class} , version = 2 , exportSchema = false)

public abstract class Book_DB extends RoomDatabase {

    public abstract Book_DAO Book_DAO();
}
