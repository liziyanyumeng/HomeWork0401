package com.bawei.liziyan20200401.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.bawei.liziyan20200401.App;


public class SpUtil {
    public static String sp_name = "app_config";
    public static void saveString(String key,String values){
        final SharedPreferences sharedPreferences = App.context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key,values);
        edit.commit();
    }

    public static void saveInt(String key,int values){
        final SharedPreferences sharedPreferences = App.context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(key,values);
        edit.commit();
    }

    public static String getString(String key){
        final SharedPreferences sharedPreferences = App.context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
        final String string = sharedPreferences.getString(key, "");
        return string;
    }

    public static int getInt(String key){
        final SharedPreferences sharedPreferences = App.context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
        final int anInt = sharedPreferences.getInt(key, -1);
        return anInt;
    }
}
