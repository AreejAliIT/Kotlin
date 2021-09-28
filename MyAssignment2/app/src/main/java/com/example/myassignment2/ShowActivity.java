package com.example.myassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ShowActivity extends AppCompatActivity {
 TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Book_DB DB= Room.databaseBuilder(this,Book_DB.class,"E_Book")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        Book_DAO dao= DB.Book_DAO();
        List<EBook> BObj= dao.getAll();

        show =findViewById(R.id.textView);
        String info="";
        for(EBook ebook : BObj ){
            String name = ebook.getAuthor_name();
            String title = ebook.getBook_title();
            String category = ebook.getBook_category();
            info=info+"\n\n\n"+ "Author name: "+name+"\n\n"+"Book title : "+title+"\n\n"+"Book category : "+category;
        }
        show.setText(info);
    }
}