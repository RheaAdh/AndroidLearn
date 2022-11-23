package com.rodavid20.filedemo.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.rodavid20.filedemo.datamodel.Student;

import java.util.ArrayList;

public class CollegeDbAdapter {
    private static String dbName = "CollegeDb";
    private static int dbVersion = 3;
    private CollegedbHelper helper;
    private SQLiteDatabase collegeDb;

    public CollegeDbAdapter(Context context){
        helper = new CollegedbHelper(context, dbName,
                null, dbVersion);
    }

    public void open(){
        collegeDb = helper.getWritableDatabase();
    }

    public void close(){
        collegeDb.close();
        collegeDb = null;
    }

    public void insertStudent(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        collegeDb.insert("student",
                null, contentValues);
    }

    public String[] getStudentNames(){

        Cursor cursor = collegeDb.query("student", new String[]{"name"},
        null, null, null, null, null);
        String[] names = new String[cursor.getCount()];
        int i =0;
        while(cursor.moveToNext()) {
            names[i++] = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        }
        return names;
    }




    private static class CollegedbHelper
            extends SQLiteOpenHelper{

        public CollegedbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE student( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT" +
                    ", deptName TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            sqLiteDatabase.execSQL("DROP TABLE student");
            sqLiteDatabase.execSQL("CREATE TABLE student( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT" +
                    ", deptName TEXT)");
        }
    }
}
