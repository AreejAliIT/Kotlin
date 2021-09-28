package com.example.assigenment;

//import androidx.arch.persistence.room.ColumnInfo;
//import androidx.arch.persistence.room.Entity;
//import androidx.arch.persistence.room.PrimaryKey;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Booking {
   @PrimaryKey (autoGenerate = true)
    private int id;
   @ColumnInfo (name = "User_name")
    private String name;
    private String email;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return name; }
    public void setEmail(String email) { this.email = email; }
}
