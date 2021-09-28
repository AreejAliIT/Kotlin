package com.example.project;

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
public final class Appointment_DB_Impl extends Appointment_DB {
  private volatile Appointment_DAO _appointmentDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Appointment_Table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Date` TEXT, `Hospital \\ Clinic` TEXT, `Dr_Name` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"9c53d00d3600fc2e696af0254856a54f\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Appointment_Table`");
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
        final HashMap<String, TableInfo.Column> _columnsAppointmentTable = new HashMap<String, TableInfo.Column>(4);
        _columnsAppointmentTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsAppointmentTable.put("Date", new TableInfo.Column("Date", "TEXT", false, 0));
        _columnsAppointmentTable.put("Hospital \\ Clinic", new TableInfo.Column("Hospital \\ Clinic", "TEXT", false, 0));
        _columnsAppointmentTable.put("Dr_Name", new TableInfo.Column("Dr_Name", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAppointmentTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAppointmentTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppointmentTable = new TableInfo("Appointment_Table", _columnsAppointmentTable, _foreignKeysAppointmentTable, _indicesAppointmentTable);
        final TableInfo _existingAppointmentTable = TableInfo.read(_db, "Appointment_Table");
        if (! _infoAppointmentTable.equals(_existingAppointmentTable)) {
          throw new IllegalStateException("Migration didn't properly handle Appointment_Table(com.example.project.Appointment).\n"
                  + " Expected:\n" + _infoAppointmentTable + "\n"
                  + " Found:\n" + _existingAppointmentTable);
        }
      }
    }, "9c53d00d3600fc2e696af0254856a54f", "3f065074c36d767ddad17e5a8b5a194d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Appointment_Table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Appointment_Table`");
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
  public Appointment_DAO Appointment_DAO() {
    if (_appointmentDAO != null) {
      return _appointmentDAO;
    } else {
      synchronized(this) {
        if(_appointmentDAO == null) {
          _appointmentDAO = new Appointment_DAO_Impl(this);
        }
        return _appointmentDAO;
      }
    }
  }
}
