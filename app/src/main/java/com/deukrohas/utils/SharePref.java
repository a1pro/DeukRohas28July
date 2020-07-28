package com.deukrohas.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.deukrohas.activities.MainActivity;

import java.util.HashMap;

public class SharePref {

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;
    // Sharedpref file name
    private static final String PREF_NAME = "DeukRohas";

    // All Shared Preferences Keys
    public static String EMAIL;
    public static String LOGIN_TYPE ;

    public SharePref(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setEmail(String email) {
        editor.putString(EMAIL, email);
        editor.commit();
    }
    public void setLoginType(String type) {
        editor.putString(LOGIN_TYPE, type);
        editor.commit();
    }


    public HashMap<String, String> getUserInfo() {
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(EMAIL, pref.getString(EMAIL, null));
        user.put(LOGIN_TYPE, pref.getString(LOGIN_TYPE,null));

        return user;
    }
    public void logoutUser(Context context){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
        // After logout redirect user to Loing Activity
        Intent i = new Intent(context, MainActivity.class);
        // Closing all the Activities
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

//        // Add new Flag to start new Activity
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(i);
    }
}
