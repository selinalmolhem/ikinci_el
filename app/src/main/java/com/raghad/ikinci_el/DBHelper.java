package com.raghad.ikinci_el;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "ikinci_el.db";

    public DBHelper(Context context) {
        super(context, "ikinci_el.db", null, 1);
        SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table user(userid integer primary key, username TEXT, password TEXT , addres TEXT, phonenumber TEXT)");
        MyDB.execSQL("create Table tooltype(tooltypeid integer primary key, tooltypename TEXT )");
        MyDB.execSQL("create Table tool(toolid integer primary key, toolname TEXT ,price TEXT, state boolean ,tooltypeid integer references tooltype(tooltypeid) , userid integer references user(userid)  )");
        MyDB.execSQL("create Table picture(pictureid integer primary key, picturePath TEXT  ,toolid integer references tool(toolid)   )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists user");
    }
}