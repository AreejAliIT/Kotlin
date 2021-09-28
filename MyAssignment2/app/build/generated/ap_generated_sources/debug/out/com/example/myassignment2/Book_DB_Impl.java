package com.example.myassignment2;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class Book_DB_Impl extends Book_DB {
  private volatile Book_DAO _bookDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `E_Book` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Author name` TEXT, `Book title` TEXT, `Book Category` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"f1da799ef8e6de65f5f8ecc705c62f9f\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `E_Book`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsEBook = new HashMap<String, TableInfo.Column>(4);
        _columnsEBook.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsEBook.put("Author name", new TableInfo.Column("Author name", "TEXT", false, 0));
        _columnsEBook.put("Book title", new TableInfo.Column("Book title", "TEXT", false, 0));
        _columnsEBook.put("Book Category", new TableInfo.Column("Book Category", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEBook = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEBook = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEBook = new TableInfo("E_Book", _columnsEBook, _foreignKeysEBook, _indicesEBook);
        final TableInfo _existingEBook = TableInfo.read(_db, "E_Book");
        if (! _infoEBook.equals(_existingEBook)) {
          throw new IllegalStateException("Migration didn't properly handle E_Book(com.example.myassignment2.EBook).\n"
                  + " Expected:\n" + _infoEBook + "\n"
                  + " Found:\n" + _existingEBook);
        }
      }
    }, "f1da799ef8e6de65f5f8ecc705c62f9f", "c767c9f77223de0c540179f241fc8a87");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "E_Book");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `E_Book`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public Book_DAO Book_DAO() {
    if (_bookDAO != null) {
      return _bookDAO;
    } else {
      synchronized(this) {
        if(_bookDAO == null) {
          _bookDAO = new Book_DAO_Impl(this);
        }
        return _bookDAO;
      }
    }
  }
}
