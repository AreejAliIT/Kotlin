package com.example.myassignment2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class InsertActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Button insert =(Button)findViewById(R.id.button3);
               insert.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                insert(view);
            }
        });
    }
    public void insert(View view) {
                Book_DB DB = Room.databaseBuilder(this, Book_DB.class, "E_Book")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
                EditText name = (EditText) findViewById(R.id.Author);
                EditText title = (EditText) findViewById(R.id.BookTitle);
                EditText category = (EditText) findViewById(R.id.Categoty);
                Book_DAO dao = DB.Book_DAO();
                EBook B = new EBook();
                String InsertName = name.getText().toString();
                String InsertTitle = title.getText().toString();
                String InsertCategory = category.getText().toString();
                B.setAuthor_name(InsertName);
                B.setBook_title(InsertTitle);
                B.setBook_category(InsertCategory);
                dao.insertAll(B);
                Message.message(getApplicationContext(), "Insertion Successfully . ");
                name.setText("");
                title.setText("");
                category.setText("");
            }
}