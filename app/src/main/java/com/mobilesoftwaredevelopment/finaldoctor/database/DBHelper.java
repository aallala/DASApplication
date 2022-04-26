package com.mobilesoftwaredevelopment.finaldoctor.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context,"doctors.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDb) {
        myDb.execSQL("create table users (id integer primary key autoincrement,email text,name text,mobileNo text,password text,role text,experience number,language text,location text,image blob)");
        myDb.execSQL( "create table contact(sno integer Primary key autoincrement,name text,email text,fname text)");
        myDb.execSQL("create table booking(bookid integer primary key autoincrement,patient_name text,healthissue text,mobile_no text,status text)");
        myDb.execSQL("create table info(sno integer Primary key autoincrement,name text,email text,fname text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDb, int i, int i1) {
        myDb.execSQL("drop table if exists users");
        myDb.execSQL("drop table if exists contact");
        myDb.execSQL("drop table if exists booking");
        myDb.execSQL("drop table if exists info");
    }

    public String addRecordInfo(String name,String email,String fname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("fname",fname);
        float res = db.insert("contact",null,cv);
        if(res == -1){
            return "Failed";
        }else{
            return "Successfully inserted";
        }
    }
    public Cursor readalldataInfo(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from contact order by sno desc";
        Cursor cursor = db.rawQuery(qry,null);
        return cursor;
    }

    public  Boolean addBooking(String patientName,String healthIsssue,String mobileNo,String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("patient_name",patientName);
        cv.put("healthissue",healthIsssue);
        cv.put("mobile_no",mobileNo);
        cv.put("status",status);
        long resultInsert = db.insert("booking",null,cv);
        if(resultInsert == -1){
            return false;
        }else{
            return true;
        }
    }


    ///Card Iteration
    public String addRecord(String name,String email,String fname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("fname",fname);
        float res = db.insert("contact",null,cv);
        if(res == -1){
            return "Faild";
        }else{
            return "Successfully inserted";
        }
    }
    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from contact order by sno desc";
        Cursor cursor = db.rawQuery(qry,null);
        return cursor;
    }
    /// Above Code Card Iteration
    public Boolean insertData(String name,String email,String mobileNo,String password,String role){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("mobileNo",mobileNo );
        contentValues.put("password",password);
        contentValues.put("role",role);
        long result = myDb.insert("users",null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean checkUser(String email){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from users where email=?",new String[] {email});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkUsernamePassword(String username,String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from users where email=? and password=?",new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }





}
