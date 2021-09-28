package com.example.project;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class Appointment_DAO_Impl implements Appointment_DAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfAppointment;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public Appointment_DAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAppointment = new EntityInsertionAdapter<Appointment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Appointment_Table`(`id`,`Date`,`Hospital \\ Clinic`,`Dr_Name`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Appointment value) {
        stmt.bindLong(1, value.getId());
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        if (value.getHospital() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getHospital());
        }
        if (value.getDr_Name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDr_Name());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from Appointment_Table";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(Appointment Appointment) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfAppointment.insert(Appointment);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<Appointment> getAll() {
    final String _sql = "select * from Appointment_Table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("Date");
      final int _cursorIndexOfHospital = _cursor.getColumnIndexOrThrow("Hospital \\ Clinic");
      final int _cursorIndexOfDrName = _cursor.getColumnIndexOrThrow("Dr_Name");
      final List<Appointment> _result = new ArrayList<Appointment>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Appointment _item;
        _item = new Appointment();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _item.setDate(_tmpDate);
        final String _tmpHospital;
        _tmpHospital = _cursor.getString(_cursorIndexOfHospital);
        _item.setHospital(_tmpHospital);
        final String _tmpDr_Name;
        _tmpDr_Name = _cursor.getString(_cursorIndexOfDrName);
        _item.setDr_Name(_tmpDr_Name);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
