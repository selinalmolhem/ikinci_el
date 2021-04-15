package com.raghad.ikinci_el;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "ikinciEl";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 2);
      //  SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table user(userid integer primary key, username TEXT, password TEXT , addres TEXT, phonenumber TEXT)");
        MyDB.execSQL("create Table tooltype(tooltypeid integer primary key, tooltypename TEXT )");
        MyDB.execSQL("create Table tool(toolid integer primary key, toolname TEXT ,price TEXT, state boolean ,tooltypeid integer references tooltype(tooltypeid) , userid integer references user(userid)  )");
        MyDB.execSQL("create Table picture(pictureid integer primary key, picturePath TEXT  ,toolid integer references tool(toolid)   )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists user");
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists tooltype");
        MyDB.execSQL("drop Table if exists tool");
        MyDB.execSQL("drop Table if exists picture");
         onCreate( MyDB);
    }
    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}