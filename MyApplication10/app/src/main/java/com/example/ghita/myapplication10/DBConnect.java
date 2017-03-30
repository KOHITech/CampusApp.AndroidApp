package com.example.ghita.myapplication10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Omar on 30/03/2017.
 */

public class DBConnect extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "campusDB";
    private static final String TABLE_EVENTS = "events";

    public DBConnect(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String KEY_ID = "id";
    private static final String KEY_DESCR = "descritpion";
    private static final String KEY_DAY = "day";
    private static final String KEY_MONTH = "month";
    private static final String KEY_YEAR = "year";

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATION = "CREATE TABLE IF NOT EXISTS "+TABLE_EVENTS+"("+ KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_DESCR+" TEXT, "+KEY_YEAR+" INT, "+KEY_MONTH+" INT, "+KEY_DAY+" INT)";
        //String query = "INSERT INTO events (description, year, month, day) " + "VALUES ( " + descr + ", " + an + ", " + mois + ", " + jour + ");";
        //db.execSQL(query);
        db.execSQL(CREATION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        onCreate(db);
    }

    public void addEvent(int an, int mois, int jour, String descr){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DESCR,descr);
        values.put(KEY_YEAR,an);
        values.put(KEY_MONTH,mois);
        values.put(KEY_DAY,jour);
        db.insert(TABLE_EVENTS,null,values);
        db.close();
    }
    public String[] getEvents(){
        int id = 0;
        String descr = null;
        int year = 0;
        int month = 0;
        int day = 0;
        String[] chaine = new String[5];
        String selectQuery = "SELECT  * FROM " + TABLE_EVENTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                id = Integer.parseInt(cursor.getString(0));
                descr = cursor.getString(1);
                year = Integer.parseInt(cursor.getString(2));
                month = Integer.parseInt(cursor.getString(3));
                day = Integer.parseInt(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        chaine[0] = String.valueOf(id);
        chaine[1] = (String) descr;
        chaine[2] = String.valueOf(year);
        chaine[3] = String.valueOf(month);
        chaine[4] = String.valueOf(day);
        return chaine;
    }
}

