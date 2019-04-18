package com.example.resumebuilder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Myresume.db";
    public static final String TABLE_NAME = "Resume_info";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PHONE_NUM";
    public static final String COL_4= "ADDRESS";
    public static final String COL_5= "SCHOOL";
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
    //public static final String COL_18= "ID";



    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    public boolean insertData(String name, String email, String phone_num, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,phone_num);
        contentValues.put(COL_4,address);

        long result = db.replace(TABLE_NAME,null,contentValues);
        if (result == -1)
            return true;
        else
            return false;
    }


    public boolean insertData1(String school, String year, String course){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5,school);
        contentValues.put(COL_6,year);
        contentValues.put(COL_7,course);
        long result = db.replace(TABLE_NAME,null,contentValues);
        if (result == -1)
            return true;
        else
            return false;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" (NAME text,EMAIL text,PHONE_NUM text,ADDRESS text,SCHOOL text,YEAR text,COURSE text,SKILLS text,PROFICIENCY text,PROJECTS text,DESCRIPTION text,TRAININGS text,ACHIEVEMENTS text,JOBS text,COMPANY text,DURATION text,HEADLINE text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }

    public boolean insertData2(String job, String duration, String company) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_14,job);
        contentValues.put(COL_16,duration);
        contentValues.put(COL_15,company);
        long result = db.replace(TABLE_NAME,null,contentValues);
        if (result == -1)
            return true;
        else
            return false;
    }

    public boolean insertData3(String skill, String proficiency) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_8,skill);
        contentValues.put(COL_9,proficiency);
        long result = db.replace(TABLE_NAME,null,contentValues);
        if (result == -1)
            return true;
        else
            return false;
    }


   /* public boolean updateData(String name, String email, String address, String phone_num){
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
