package com.example.task.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.task.Constants;
import com.example.task.User;

public class DatabaseHandler extends SQLiteOpenHelper {



    private String CREATE_USER_TABLE = "CREATE TABLE " + Constants.TABLE_USER + "("
            + Constants.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Constants.COLUMN_USER_NAME + " TEXT,"
            + Constants.COLUMN_USER_EMAIL + " TEXT,"+ Constants.COLUMN_USER_AGE + " TEXT," + Constants.COLUMN_USER_PASSWORD + " TEXT" + ")";
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + Constants.TABLE_USER;

    public DatabaseHandler(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COLUMN_USER_NAME, user.getFullName());
        values.put(Constants.COLUMN_USER_EMAIL, user.getEmail());
        values.put(Constants.COLUMN_USER_PASSWORD, user.getPassword());
        values.put(Constants.COLUMN_USER_AGE, user.getAge());
        db.insert(Constants.TABLE_USER, null, values);
        db.close();
    }

    public boolean checkUser(String email) {
        String[] columns = {
                Constants.COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = Constants.COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = {email};

        Cursor cursor = db.query(Constants.TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) return true;
        return false;
    }

    public boolean checkUserLogin(String email, String password) {
        // array of columns to fetch
        String[] columns = {
                Constants.COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = Constants.COLUMN_USER_EMAIL + " = ?" + " AND " + Constants.COLUMN_USER_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(Constants.TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) return true;
        return false;
    }
}