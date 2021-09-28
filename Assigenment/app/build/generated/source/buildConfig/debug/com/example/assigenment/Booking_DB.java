package com.example.assigenment;

import android.arch.persistence.room.Database;

@Database
public abstract class Booking_DB extends RoomDatabase{

    public abstract booking_DAO booking_dao();
}
