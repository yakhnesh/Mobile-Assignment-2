package com.example.mobileassignment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBHandler extends SQLiteOpenHelper{

    private static final String DB_NAME = "geodb";


    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "GeoCoder";
    private static final String ID_COL = "id";
    private static final String ADDRESS_COL = "address";
    private static final String LATITUDE_COL = "latitude";
    private static final String LONGITUDE_COL = "longitude";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ADDRESS_COL + " TEXT,"
                + LATITUDE_COL + " TEXT,"
                + LONGITUDE_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    public void addNew(String address, String latitude, String longitude){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ADDRESS_COL, address);
        values.put(LATITUDE_COL, latitude);
        values.put(LONGITUDE_COL, longitude);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

public ArrayList<GeoModel> readGeo() {
        SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursorGeo = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    ArrayList<GeoModel> courseGeoArrayList = new ArrayList<>();

    if (cursorGeo.moveToFirst()){
        do {
            courseGeoArrayList.add(new GeoModel(cursorGeo.getString(1),
                    cursorGeo.getString(2),
                    cursorGeo.getString(3)));
        } while (cursorGeo.moveToNext());
    }
    cursorGeo.close();
    return courseGeoArrayList;
}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
