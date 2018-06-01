package com.fish.cashflow;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "Cashflow.db";
    public static final String TABLE_NAME = "cashflowTable";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "EXPENSE";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "DATE";
    public static final String COL_5 = "CATEGORY";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,EXPENSE INTEGER,DESCRIPTION TEXT,DATE TEXT,CATEGORY TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String expense, String description, String date, String category)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, expense);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, date);
        contentValues.put(COL_5, category);
        long res = db.insert(TABLE_NAME, null, contentValues);
        if(res == -1)
            return false;
        else
            return true;
    }
}
