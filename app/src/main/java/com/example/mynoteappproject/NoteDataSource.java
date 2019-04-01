package com.example.mynoteappproject;

public class NoteDataSource {

    private SQLiteDatabase database;
    private NoteDatabase dbHelper;

    public NoteDataSource (Context context) {
        dbHelper = new NoteDatabase(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }
}
