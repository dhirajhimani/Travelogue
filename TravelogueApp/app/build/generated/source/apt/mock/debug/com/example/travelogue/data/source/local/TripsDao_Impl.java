package com.example.travelogue.data.source.local;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.example.travelogue.data.models.Trip;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class TripsDao_Impl implements TripsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTrip;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTrip;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTripById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTrips;

  public TripsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrip = new EntityInsertionAdapter<Trip>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `trips`(`id`,`userId`,`destination`,`startDate`,`endDate`,`description`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Trip value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getUserId());
        if (value.getDestination() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDestination());
        }
        if (value.getStartDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getStartDate());
        }
        if (value.getEndDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getEndDate());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescription());
        }
      }
    };
    this.__updateAdapterOfTrip = new EntityDeletionOrUpdateAdapter<Trip>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `trips` SET `id` = ?,`userId` = ?,`destination` = ?,`startDate` = ?,`endDate` = ?,`description` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Trip value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getUserId());
        if (value.getDestination() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDestination());
        }
        if (value.getStartDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getStartDate());
        }
        if (value.getEndDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getEndDate());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescription());
        }
        stmt.bindLong(7, value.getId());
      }
    };
    this.__preparedStmtOfDeleteTripById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Trips WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTrips = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Trips";
        return _query;
      }
    };
  }

  @Override
  public void insertTrip(Trip trip) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrip.insert(trip);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateTrip(Trip trip) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfTrip.handle(trip);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteTripById(String tripId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTripById.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (tripId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, tripId);
      }
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTripById.release(_stmt);
    }
  }

  @Override
  public void deleteTrips() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTrips.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTrips.release(_stmt);
    }
  }

  @Override
  public List<Trip> getTrips(String userId) {
    final String _sql = "SELECT * FROM Trips WHERE userId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfMUserId = _cursor.getColumnIndexOrThrow("userId");
      final int _cursorIndexOfMDestination = _cursor.getColumnIndexOrThrow("destination");
      final int _cursorIndexOfMStartDate = _cursor.getColumnIndexOrThrow("startDate");
      final int _cursorIndexOfMEndDate = _cursor.getColumnIndexOrThrow("endDate");
      final int _cursorIndexOfMDescription = _cursor.getColumnIndexOrThrow("description");
      final List<Trip> _result = new ArrayList<Trip>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Trip _item;
        final int _tmpMId;
        _tmpMId = _cursor.getInt(_cursorIndexOfMId);
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        final String _tmpMDestination;
        _tmpMDestination = _cursor.getString(_cursorIndexOfMDestination);
        final Long _tmpMStartDate;
        if (_cursor.isNull(_cursorIndexOfMStartDate)) {
          _tmpMStartDate = null;
        } else {
          _tmpMStartDate = _cursor.getLong(_cursorIndexOfMStartDate);
        }
        final Long _tmpMEndDate;
        if (_cursor.isNull(_cursorIndexOfMEndDate)) {
          _tmpMEndDate = null;
        } else {
          _tmpMEndDate = _cursor.getLong(_cursorIndexOfMEndDate);
        }
        final String _tmpMDescription;
        _tmpMDescription = _cursor.getString(_cursorIndexOfMDescription);
        _item = new Trip(_tmpMId,_tmpMUserId,_tmpMDestination,_tmpMStartDate,_tmpMEndDate,_tmpMDescription);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Trip getTripById(String tripId) {
    final String _sql = "SELECT * FROM Trips WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tripId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tripId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfMUserId = _cursor.getColumnIndexOrThrow("userId");
      final int _cursorIndexOfMDestination = _cursor.getColumnIndexOrThrow("destination");
      final int _cursorIndexOfMStartDate = _cursor.getColumnIndexOrThrow("startDate");
      final int _cursorIndexOfMEndDate = _cursor.getColumnIndexOrThrow("endDate");
      final int _cursorIndexOfMDescription = _cursor.getColumnIndexOrThrow("description");
      final Trip _result;
      if(_cursor.moveToFirst()) {
        final int _tmpMId;
        _tmpMId = _cursor.getInt(_cursorIndexOfMId);
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        final String _tmpMDestination;
        _tmpMDestination = _cursor.getString(_cursorIndexOfMDestination);
        final Long _tmpMStartDate;
        if (_cursor.isNull(_cursorIndexOfMStartDate)) {
          _tmpMStartDate = null;
        } else {
          _tmpMStartDate = _cursor.getLong(_cursorIndexOfMStartDate);
        }
        final Long _tmpMEndDate;
        if (_cursor.isNull(_cursorIndexOfMEndDate)) {
          _tmpMEndDate = null;
        } else {
          _tmpMEndDate = _cursor.getLong(_cursorIndexOfMEndDate);
        }
        final String _tmpMDescription;
        _tmpMDescription = _cursor.getString(_cursorIndexOfMDescription);
        _result = new Trip(_tmpMId,_tmpMUserId,_tmpMDestination,_tmpMStartDate,_tmpMEndDate,_tmpMDescription);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
