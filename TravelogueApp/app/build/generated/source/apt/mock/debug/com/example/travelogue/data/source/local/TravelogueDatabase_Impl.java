package com.example.travelogue.data.source.local;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class TravelogueDatabase_Impl extends TravelogueDatabase {
  private volatile UsersDao _usersDao;

  private volatile TripsDao _tripsDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT, `type` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `trips` (`id` INTEGER NOT NULL, `userId` INTEGER NOT NULL, `destination` TEXT NOT NULL, `startDate` INTEGER NOT NULL, `endDate` INTEGER NOT NULL, `description` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"06f887e7ee79136b99d66c150cdfafef\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `users`");
        _db.execSQL("DROP TABLE IF EXISTS `trips`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(5);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", false, 0));
        _columnsUsers.put("type", new TableInfo.Column("type", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(_db, "users");
        if (! _infoUsers.equals(_existingUsers)) {
          throw new IllegalStateException("Migration didn't properly handle users(com.example.travelogue.data.models.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsTrips = new HashMap<String, TableInfo.Column>(6);
        _columnsTrips.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsTrips.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0));
        _columnsTrips.put("destination", new TableInfo.Column("destination", "TEXT", true, 0));
        _columnsTrips.put("startDate", new TableInfo.Column("startDate", "INTEGER", true, 0));
        _columnsTrips.put("endDate", new TableInfo.Column("endDate", "INTEGER", true, 0));
        _columnsTrips.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrips = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTrips = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrips = new TableInfo("trips", _columnsTrips, _foreignKeysTrips, _indicesTrips);
        final TableInfo _existingTrips = TableInfo.read(_db, "trips");
        if (! _infoTrips.equals(_existingTrips)) {
          throw new IllegalStateException("Migration didn't properly handle trips(com.example.travelogue.data.models.Trip).\n"
                  + " Expected:\n" + _infoTrips + "\n"
                  + " Found:\n" + _existingTrips);
        }
      }
    }, "06f887e7ee79136b99d66c150cdfafef");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "users","trips");
  }

  @Override
  public UsersDao userDao() {
    if (_usersDao != null) {
      return _usersDao;
    } else {
      synchronized(this) {
        if(_usersDao == null) {
          _usersDao = new UsersDao_Impl(this);
        }
        return _usersDao;
      }
    }
  }

  @Override
  public TripsDao tripDao() {
    if (_tripsDao != null) {
      return _tripsDao;
    } else {
      synchronized(this) {
        if(_tripsDao == null) {
          _tripsDao = new TripsDao_Impl(this);
        }
        return _tripsDao;
      }
    }
  }
}
