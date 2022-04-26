package com.mobilesoftwaredevelopment.finaldoctor;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    //Initialize Variable
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    //Create Constructor

    public SessionManager(Context context){
        sharedPreferences = context.getSharedPreferences("AppKey",0);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public SessionManager() {

    }

    //Create set login method
    public void setLogin(boolean login){
        editor.putBoolean("KEY_LOGIN",login);
        editor.commit();
    }

    //Create get Login method
    public boolean getLogin(){
        return sharedPreferences.getBoolean("KEY_LOGIN",false);
    }

    //Create set USername method
    public void setUsername(String username){
        editor.putString("KEY_USERNAME",username);
        editor.commit();
    }

    //Create get username method
    public String getUsername(){
        return sharedPreferences.getString("KEY_USERNAME","");
    }



}
