package com.example.mynoteappproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class NoteDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "notesapp.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_NOTE =
            "Create table note" + table_Notes + " (" +
                    note_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    note_Text + " TEXT, " +
                    note_Priority + " INTEGER, " +
                    note_Create + " TEXT default CURRENT_TIMESTAMP" +
                    ")";
    public NoteDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_NOTE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(NoteDatabase.class.getName(), "Upgrading database from version " + oldVersion + "to" + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS note");
        onCreate(db);
    }

}