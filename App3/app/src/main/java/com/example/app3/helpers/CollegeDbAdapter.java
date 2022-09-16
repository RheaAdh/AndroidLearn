package com.example.app3.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CollegeDbAdapter {
    private static String dbName="CollegeDb";
    private static int dbVersion=1;

    private static CollegeDbHelper helper;
    private SQLiteDatabase collegeDb;

    public CollegeDbAdapter(Context context){
        helper = new CollegeDbHelper(context,dbName,null,dbVersion);
    }

    public void Open(){
        collegeDb = helper.getWritableDatabase();
    }
    public void Close(){
        collegeDb.close();
    }

    private static class CollegeDbHelper extends SQLiteOpenHelper{


        public CollegeDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
