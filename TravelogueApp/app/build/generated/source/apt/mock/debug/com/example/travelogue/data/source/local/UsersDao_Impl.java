package com.example.travelogue.data.source.local;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.example.travelogue.data.models.User;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class UsersDao_Impl implements UsersDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUserById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUsers;

  public UsersDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `users`(`id`,`name`,`email`,`password`,`type`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPassword());
        }
        stmt.bindLong(5, value.getType());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `users` SET `id` = ?,`name` = ?,`email` = ?,`password` = ?,`type` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPassword());
        }
        stmt.bindLong(5, value.getType());
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDeleteUserById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Users WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUsers = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Users";
        return _query;
      }
    };
  }

  @Override
  public void insertUser(User user) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateUser(User user) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteUserById(String userId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUserById.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (userId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, userId);
      }
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteUserById.release(_stmt);
    }
  }

  @Override
  public void deleteUsers() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUsers.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteUsers.release(_stmt);
    }
  }

  @Override
  public List<User> getUsers() {
    final String _sql = "SELECT * FROM Users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfMName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfMEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfMPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfMType = _cursor.getColumnIndexOrThrow("type");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final int _tmpMId;
        _tmpMId = _cursor.getInt(_cursorIndexOfMId);
        final String _tmpMName;
        _tmpMName = _cursor.getString(_cursorIndexOfMName);
        final String _tmpMEmail;
        _tmpMEmail = _cursor.getString(_cursorIndexOfMEmail);
        final String _tmpMPassword;
        _tmpMPassword = _cursor.getString(_cursorIndexOfMPassword);
        final int _tmpMType;
        _tmpMType = _cursor.getInt(_cursorIndexOfMType);
        _item = new User(_tmpMId,_tmpMName,_tmpMEmail,_tmpMPassword,_tmpMType);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUserById(String userId) {
    final String _sql = "SELECT * FROM Users WHERE id = ?";
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
      final int _cursorIndexOfMName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfMEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfMPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfMType = _cursor.getColumnIndexOrThrow("type");
      final User _result;
      if(_cursor.moveToFirst()) {
        final int _tmpMId;
        _tmpMId = _cursor.getInt(_cursorIndexOfMId);
        final String _tmpMName;
        _tmpMName = _cursor.getString(_cursorIndexOfMName);
        final String _tmpMEmail;
        _tmpMEmail = _cursor.getString(_cursorIndexOfMEmail);
        final String _tmpMPassword;
        _tmpMPassword = _cursor.getString(_cursorIndexOfMPassword);
        final int _tmpMType;
        _tmpMType = _cursor.getInt(_cursorIndexOfMType);
        _result = new User(_tmpMId,_tmpMName,_tmpMEmail,_tmpMPassword,_tmpMType);
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
