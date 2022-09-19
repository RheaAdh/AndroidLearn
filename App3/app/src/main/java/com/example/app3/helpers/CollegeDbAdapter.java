package com.example.app3.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        collegeDb = null;
    }

    public void InsertStudent(String name){
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        collegeDb.insert("student",null,contentValues);
    }

    public String getStudents(){
        String name="";
        Cursor cursor = collegeDb.query("student",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            name = name +";"+ cursor.getString(cursor.getColumnIndexOrThrow("name"));
        }
        return name;
    }
    private static class CollegeDbHelper extends SQLiteOpenHelper{


        public CollegeDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE student " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
