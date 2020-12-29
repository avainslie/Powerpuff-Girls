package com.example.powerpuffgirls;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Resource.db"; // not case sensitive
    public static final String RESOURCE_TABLE = "RESOURCE_TABLE";
    public static final String COLUMN_RESOURCE_NAME = "NAME";
    public static final String COLUMN_RESOURCE_DESCP = "DESCP";
    public static final String COLUMN_RESOURCE_LINK = "LINK";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    // Called the first time a database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Primary Key "makes that value the unique identifier for the row in the table"
        // When you use autoincrement "SQL engine makes sure that it picks a completely new id, one that wasn't even used by deleted rows"
        String createTableStatement = "CREATE TABLE " + RESOURCE_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RESOURCE_NAME + ", " + COLUMN_RESOURCE_DESCP + ", " + COLUMN_RESOURCE_LINK + ")";

        db.execSQL(createTableStatement); // Executes query

    }


    // Called if the database version number changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + RESOURCE_TABLE); // Spaces inbetween " and query sentence are important!
        onCreate(db);

    }
}
