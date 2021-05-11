package com.raghad.ikinci_el;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "q1";
    private static final int DB_VERSION =2;
    private static final String buy_TABLE = "buy_list";
    public static final String buy_ID = "id";
    public static final String buy_email= "email";
    public static final String buy_name = "name";
    public static final String buy_adress= "adress";
    public static final String buy_phone= "phone";
    public static final String buy_message = "message";
    public static final String buy_image = "image";

    //sell
    private static final String sell_TABLE = "sell_list";
    public static final String sell_ID = "id";
    public static final String sell_name = "ad";
    public static final String sell_phone = "phone";
    public static final String sell_email = "email";
    public static final String sell_note = "note";
    public static final String sell_adress = "adress";

    public static final String TABLE_image = "table_image";
    public static final String Sellimage = "sellimage";

    //profil
    private static final String profil_TABLE = "profil_list";
    public static final String profil_ID = "id";
    public static final String profil_name = "ad";
    public static final String profil_surname = "surname";
    public static final String profil_date = "date";
    public static final String profil_gender = "gender";
    public static final String profil_email = "email";
    public static final String profil_phone = "phone";
    public static final String profil_adress = "adress";

    public DBHelper(Context context) {
        super(context, DBNAME, null, DB_VERSION);
       // SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table profil(name TEXT,surname TEXT,date TEXT,gender TEXT,email TEXT,phone TEXT, adress TEXT)");
        MyDB.execSQL("create Table user(userid integer primary key, username TEXT, password TEXT , addres TEXT, phonenumber TEXT)");
       // MyDB.execSQL("create Table tooltype(tooltypeid integer primary key, tooltypename TEXT )");
       // MyDB.execSQL("create Table tool(toolid integer primary key, toolname TEXT ,price TEXT, state boolean ,tooltypeid integer references tooltype(tooltypeid) , userid integer references user(userid)  )");
     //   MyDB.execSQL("create Table picture(pictureid integer primary key, picturePath TEXT  ,toolid integer references tool(toolid)   )");
        MyDB.execSQL("CREATE TABLE " +buy_TABLE+ " ("+ buy_email+" TEXT NOT NULL , "+ buy_name+" TEXT NOT NULL, "+ buy_adress+" TEXT NOT NULL, "+ buy_phone+" TEXT NOT NULL, "+ buy_message+" TEXT NOT NULL)");
        MyDB.execSQL("CREATE TABLE " +sell_TABLE+ " ("+ sell_name+" TEXT NOT NULL , "+ sell_phone+" TEXT NOT NULL, "+ sell_email+" TEXT NOT NULL, "+ sell_note+" TEXT NOT NULL, "+ sell_adress+" TEXT NOT NULL," + Sellimage+" BLOB)");
       // MyDB.execSQL("CREATE TABLE " +TABLE_image+ "("+ Sellimage+" BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists "+buy_TABLE);
        MyDB.execSQL("drop Table if exists "+sell_TABLE);

        MyDB.execSQL("drop Table if exists user");
        MyDB.execSQL("drop Table if exists profil");
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
    public void VeriEkle(String email,String name,String adress,String phone,String message){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv =new ContentValues();
       // ByteArrayOutputStream outputStream =new ByteArrayOutputStream();

        cv.put(buy_email,email.trim());
        cv.put(buy_name,name.trim());
        cv.put(buy_adress,adress.trim());
        cv.put(buy_phone,phone.trim());
        cv.put(buy_message,message);
      //  cv.put(buy_image,image);
        db.insert(buy_TABLE,null, cv);
        db.close();
    }
    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunler = {buy_email,buy_name,buy_adress,buy_phone,buy_message};
        Cursor cursor = db.query(buy_TABLE , sutunler ,null , null , null , null , null);
        while (cursor.moveToNext()){
            veriler.add("From : "+cursor.getString(0)+"\nName : "+cursor.getString(1)+"\nAçdress : "+cursor.getString(2)+"\nPhone : "+cursor.getString(3)+"\nMessage : "+cursor.getString(4));
        }
        /*String query = "SELECT * FROM "+KUrum_TABLE;
       db.rawQuery()*/
        return veriler;
    }
  /*  public void imageEkle(byte[] image){
        SQLiteDatabase sql = "INSERT INTO "+buy_TABLE+"VALUES {}"

    }*/
  public void VeriEkle1(String ad,String phone,String email,String note,String adress,byte[] image){
      SQLiteDatabase db =this.getWritableDatabase();
      ContentValues cv =new ContentValues();

      // ByteArrayOutputStream outputStream =new ByteArrayOutputStream();

      cv.put(sell_name,ad.trim());
      cv.put(sell_phone,phone.trim());
      cv.put(sell_email,email.trim());
      cv.put(sell_note,note.trim());
      cv.put(sell_adress,adress.trim());
      cv.put(Sellimage, image);
      System.out.println(note.trim());
      System.out.println("llllllllllllllll"+image);
      db.insert(sell_TABLE,null, cv);
      db.close();
  }
    Sell_java ss= new Sell_java();
    public List<Sell_java> VeriListele1(){
        List<Sell_java> veriler = new ArrayList<Sell_java>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunler = {sell_name,sell_phone,sell_email,sell_note,sell_adress,Sellimage};
        Cursor cursor = db.query(sell_TABLE , sutunler ,null , null , null , null , null);
        while (cursor.moveToNext()){
          //  byte[] gelenResimByte = cursor1.getBlob(0);
            //Bitmap gelenResim = BitmapFactory.decodeByteArray(gelenResimByte,0,gelenResimByte.length);
        //    veriler.add(cursor.getString(cursor.getColumnIndex("0"))+"\nphone : "+cursor.getString(1)+"\nEmail : "+cursor.getString(2)+"\nNote : "+cursor.getString(3)+"\nAdress : "+cursor.getString(4));
        }

        return veriler;
    }
    public Bitmap VeriListelephoto(Bitmap gelenResim){
        //List<Bitmap> veriler = new ArrayList<Bitmap>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunler = {Sellimage};
        Cursor cursor = db.query(TABLE_image , sutunler ,null , null , null , null , null);
        while (cursor.moveToNext()){
            byte[] gelenResimByte = cursor.getBlob(0);
            gelenResim = BitmapFactory.decodeByteArray(gelenResimByte,0,gelenResimByte.length);
        }
        return gelenResim;

    }
    public void deletedata (String ad)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String sql ="DELETE FROM sell_list WHERE ad=?";
        SQLiteStatement statement =MyDB.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, String.valueOf(ad));
        statement.execute();
        MyDB.execSQL("delete from  sell_list where ad ="+ad);
        MyDB.close();
    }
    public void deleteSell(String ad){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("sell_list","ad=?", new String[]{ad});
    }
    public Cursor getData(String sql){
        SQLiteDatabase database =getReadableDatabase();
        return database.rawQuery(sql,null);

    }
    void updatasell(String ad,String phone,String email,String note,String adress,byte[] image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(sell_name, ad);
        cv.put(sell_phone, phone);
        cv.put(sell_email, email);
        cv.put(sell_note, note);
        cv.put(sell_adress, adress);
        cv.put(Sellimage, image);
        System.out.println(note.trim());
        System.out.println("llllllllllllllll"+image);
        long result = db.update("sell_list",cv,"ad=?", new String[]{ad});
        db.close();

    }
}