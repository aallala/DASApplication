package com.mobilesoftwaredevelopment.finaldoctor.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //doctors_appointment
    public DatabaseHelper(@Nullable Context context) {
        super(context, "demo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users (uid integer primary key autoincrement,name text,email text,mobile_no text,password text,image blob)");
        sqLiteDatabase.execSQL("create table doctors (did integer primary key autoincrement,dname text,demail text,dmobile_no text,dpassword text,exprience text,categorie text,Specialization text,image blob)");
        sqLiteDatabase.execSQL("create table booking (bid integer primary key autoincrement,patient_name text,health_issue text,mobile_no number,categorie text,doctor_id text,date text,slot text,bookedUser text,status text)");
        sqLiteDatabase.execSQL("create table documents (documentid integer primary key autoincrement,patient_name text,document_name text,image blob)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        sqLiteDatabase.execSQL("drop table if exists doctors");
        sqLiteDatabase.execSQL("drop table if exists booking");
        sqLiteDatabase.execSQL("drop table if exists documents");
    }


    // Patient Registration
    public String userRegistration(String name,String email,String password,String mobile_no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("mobile_no",mobile_no);
        cv.put("password",password);
        long result = db.insert("users", null, cv);
        if(result == -1){
            return "Failed";
        }else{
            return "Success";
        }
    }

    // Doctor Registration
    public Boolean doctorRegistration(String name,String email,String password,String mobile_no){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("dname",name);
        cv.put("demail",email);
        cv.put("dmobile_no",mobile_no);
        cv.put("dpassword",password);
        long result = db.insert("doctors", null, cv);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    // check Patient email
    public Boolean checkUser(String email){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from users where email=?",new String[] {email});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }


    //patient
    public boolean checkUsernamePassword(String username,String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from users where email=? and mobile_no=?",new String[] {username,password});
        int count = cursor.getCount();
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
    // check Doctore email
    public Boolean checkDoctor(String email){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from doctors where demail=?",new String[] {email});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
    //Doctor  and dpassword=?
    public Boolean checkDoctorUsernamePassword(String username,String password){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor cursor = myDb.rawQuery("select * from doctors where demail=? and dmobile_no=?",new String[] {username,password});
        int count = cursor.getCount();
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
       
    }


    public String addBookingRecords(String patientName, String healthIssue, String mobileMo,String dCategories,String dId,String dBookingDate,String dBookingTime,String loggedUserUsername,String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("patient_name",patientName);
        cv.put("health_issue",healthIssue);
        cv.put("mobile_no",mobileMo);
        cv.put("categorie",dCategories);
        cv.put("doctor_id",dId);
        cv.put("date",dBookingDate);
        cv.put("slot",dBookingTime);
        cv.put("bookedUser",loggedUserUsername);
        cv.put("status",status);
        long result = db.insert("booking", null, cv);
        if(result == -1){
            return "Failed";
        }else{
            return "Success";
        }
    }

    //userd By Doctors
    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from booking order by bid desc";
        Cursor cursor = db.rawQuery(qry,null);
        return cursor;
    }

    //getting Booking  Data Based in UserId User
    public Cursor getBookingDataBasedOnUId(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from booking where bookedUser=?",new String[] {username});
        return cursor;
    }

    //getting Booking  Data Based in DoctorId
    public Cursor getPendingStatus(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String status = "Pending";
        Cursor cursor = db.rawQuery("select * from booking where doctor_id=? and status=?",new String[] {username,status});
        return cursor;
    }

    public Cursor getCompletedStatus(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String status = "Completed";
        String qry = "select * from booking order by bid desc";
        Cursor cursor = db.rawQuery("select * from booking where doctor_id=? and status=?",new String[] {username,status});
        return cursor;
    }

//Categories Based Getting
    public Cursor allDataBasedOnCategories(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from doctors where categorie=?", new String[]{id});
        return cursor;
    }

    //Doctors Information
    public Cursor getUserInformation(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from doctors where demail=?",new String[] {username});
        return cursor;
    }

    //User information
    public Cursor getUserInfo(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?",new String[] {username});
        return cursor;
    }

    //Updated The Doctors information
    public Boolean updateDoctorsInfo(String s, String expert, String specia, String username, Bitmap image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("exprience",expert);
        cv.put("categorie",s);
        cv.put("Specialization",specia);
//        ByteArrayOutputStream baos=new ByteArrayOutputStream();
//        image.compress(Bitmap.CompressFormat.PNG,100, baos);
//        byte [] b=baos.toByteArray();
//        String temp= Base64.encodeToString(b, Base64.DEFAULT);
//        cv.put("image", temp);
        Cursor cursor = db.rawQuery("select * from doctors where demail=?",new String[] {username});
        if(cursor.getCount()>0) {
        int doctors = 0;
        try{
            doctors = db.update("doctors", cv, "demail=?", new String[]{username});
        }catch(SQLiteBlobTooBigException e){
            e.printStackTrace();
        }

            if (doctors == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public Cursor completedCount(String date1) {
        SQLiteDatabase db = this.getWritableDatabase();
        String status = "Completed";
        Cursor cursor = db.rawQuery("select count(status) from booking where date=? and status=?", new String[]{date1,status});
        return cursor;
    }

    public Cursor pendingCount(String date1) {
        SQLiteDatabase db = this.getWritableDatabase();
        String status = "Pending";
        Cursor cursor = db.rawQuery("select count(status) from booking where date=? and status=?", new String[]{date1,status});
        return cursor;
    }

    public boolean updatePatientOpStatus(String status,String id,String pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("status",status);
        int doctors = db.update("booking", cv, "bid=?", new String[]{pid});
        if(doctors > 0){
            return true;
        }else{
            return false;
        }
    }
}
