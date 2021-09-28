package com.example.myassignment2;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class Book_DAO_Impl implements Book_DAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfEBook;

  public Book_DAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEBook = new EntityInsertionAdapter<EBook>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `E_Book`(`id`,`Author name`,`Book title`,`Book Category`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBook value) {
        stmt.bindLong(1, value.getId());
        if (value.getAuthor_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthor_name());
        }
        if (value.getBook_title() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBook_title());
        }
        if (value.getBook_category() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBook_category());
        }
      }
    };
  }

  @Override
  public void insertAll(EBook EBook) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBook.insert(EBook);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<EBook> getAll() {
    final String _sql = "select * from E_Book";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfAuthorName = _cursor.getColumnIndexOrThrow("Author name");
      final int _cursorIndexOfBookTitle = _cursor.getColumnIndexOrThrow("Book title");
      final int _cursorIndexOfBookCategory = _cursor.getColumnIndexOrThrow("Book Category");
      final List<EBook> _result = new ArrayList<EBook>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EBook _item;
        _item = new EBook();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpAuthor_name;
        _tmpAuthor_name = _cursor.getString(_cursorIndexOfAuthorName);
        _item.setAuthor_name(_tmpAuthor_name);
        final String _tmpBook_title;
        _tmpBook_title = _cursor.getString(_cursorIndexOfBookTitle);
        _item.setBook_title(_tmpBook_title);
        final String _tmpBook_category;
        _tmpBook_category = _cursor.getString(_cursorIndexOfBookCategory);
        _item.setBook_category(_tmpBook_category);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
