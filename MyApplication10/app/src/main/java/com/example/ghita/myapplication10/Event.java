package com.example.ghita.myapplication10;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Omar on 20/01/2017.
 */

public class Event {

    static private SQLiteDatabase db;
    static private SQLiteDatabase.CursorFactory factory;
    static private Cursor c;

    private static final String SELECT_SQL = "SELECT * FROM events";

    static public int id;
    static public String description;
    static public int year;
    static public int month;
    static public int day;
    static public void addEvent(int an, int mois, int jour, String descr){
        description = descr;
        year = an;
        month = mois;
        day = jour;
        db = db.openOrCreateDatabase("campusDB", factory, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS events(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, description VARCHAR, year INT, month INT, day INT);");
        String query = "INSERT INTO events (description, year, month, day) " + "VALUES ( " + description + ", " + year + ", " + month + ", " + day + ");";
        db.execSQL(query);
    }
    static public int getEventId(){
        c = db.rawQuery(SELECT_SQL,null);
        c.moveToFirst();
        id = c.getInt(0);
        return id;
    }
}
