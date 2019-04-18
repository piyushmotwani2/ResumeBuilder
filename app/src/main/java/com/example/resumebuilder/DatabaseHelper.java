package com.example.resumebuilder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "resume.db";
    public static final String TABLE_NAME = "basic_info";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PHONE_NUM";
    public static final String COL_4= "ADDRESS";
    /*public static final String COL_5= "SCHOOL";
    public static final String COL_6= "YEAR";
    public static final String COL_7= "COURSE";
    public static final String COL_8= "SKILLS";
    public static final String COL_9= "PROFICIENCY";
    public static final String COL_10= "PROJECTS";
    public static final String COL_11= "DESCRIPTION";
    public static final String COL_12= "TRAININGS";
    public static final String COL_13= "ACHIEVEMENTS";
    public static final String COL_14= "JOBS";
    public static final String COL_15= "COMPANY";
    public static final String COL_16= "DURATION";
    public static final String COL_17= "HEADLINE";
    */



    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    public boolean insertData(String name, String email, String address, String phone_num){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,phone_num);
        contentValues.put(COL_4,address);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return true;
        else
            return false;
    }


    /*public boolean insertData1(String name, String email, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5,name);
        contentValues.put(COL_15,email);
        contentValues.put(COL_14,address);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return true;
        else
            return false;
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS "+ TABLE_NAME + " (NAME text,EMAIL text,PHONE_NUM integer,ADDRESS text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS base");
        onCreate(db);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }


    public boolean updateData(String name, String email, String address, String phone_num){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,phone_num);
        contentValues.put(COL_4,address);
        db.update(TABLE_NAME,contentValues,"NAME = ?",new String[]{ name });
        return true;
    }

    /*public boolean updateData1(String name, String email, String address, String update){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5,name);
        contentValues.put(COL_15,email);
        contentValues.put(COL_14,address);
        db.update(TABLE_NAME,contentValues,"SCHOOL = ?",new String[]{ update });
        return true;
    }*/
}
