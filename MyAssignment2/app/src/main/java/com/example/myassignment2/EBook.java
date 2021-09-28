package com.example.myassignment2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "E_Book")
public class EBook {

    @PrimaryKey (autoGenerate = true)
    private int id;
    @ColumnInfo(name="Author name")
    private String author_name;
    @ColumnInfo(name="Book title")
    private String book_title;
    @ColumnInfo(name="Book Category")
    private String  book_category;

    // ID
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    // Author_name
    public String getAuthor_name() { return author_name; }
    public void setAuthor_name(String author_name) { this.author_name = author_name; }
    //Book_title
    public String getBook_title() { return book_title; }
    public void setBook_title(String book_title) { this.book_title = book_title; }
    //Book_category
    public String getBook_category() { return book_category; }
    public void setBook_category(String book_category) { this.book_category = book_category; }
}
