package com.raghad.ikinci_el;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Sell_java {
    String add;
    String phonee;
    String emaill;
    String notee;
    String adress;
    Bitmap sellResim;

    public Sell_java() {
    }

    public Sell_java(String add, String phonee, String emaill, String notee, String adress, Bitmap sellResim) {
        this.add = add;
        this.phonee = phonee;
        this.emaill = emaill;
        this.notee = notee;
        this.adress = adress;
        this.sellResim = sellResim;
    }

    public Bitmap getSellResim() {
        return sellResim;
    }

    public void setSellResim(Bitmap sellResim) {
        this.sellResim = sellResim;
    }

    public String getAdd() {
        System.out.println("kkkkkkkkkkselljava" +add);
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPhonee() {
        return phonee;
    }

    public void setPhonee(String phonee) {
        this.phonee = phonee;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public String getNotee() {
        return notee;
    }

    public void setNotee(String notee) {
        this.notee = notee;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    static public ArrayList<Sell_java> getData(Context context) {
        ArrayList<Sell_java> sellList = new ArrayList<>();
        ArrayList<String> addList = new ArrayList<>();
        ArrayList<String> phoneeList = new ArrayList<>();
        ArrayList<String> emaillList = new ArrayList<>();
        ArrayList<String> adressList = new ArrayList<>();
        ArrayList<String> noteeList = new ArrayList<>();
        ArrayList<Bitmap> sellResimList = new ArrayList<>();
        try {
            SQLiteDatabase database = context.openOrCreateDatabase("q1", Context.MODE_PRIVATE, null);
            Cursor cursor = database.rawQuery("SELECT * FROM sell_list", null);
            int w1=cursor.getColumnIndex("ad");
            int w2=cursor.getColumnIndex("phone");
            int w3=cursor.getColumnIndex("email");
            int w5=cursor.getColumnIndex("adress");
            int w4 =cursor.getColumnIndex("note");
            int w6 =cursor.getColumnIndex("sellimage");


            while (cursor.moveToNext()) {
                addList.add(cursor.getString(w1));
                phoneeList.add(cursor.getString(w2));
                emaillList.add(cursor.getString(w3));
                noteeList.add(cursor.getString(w4));
                adressList.add(cursor.getString(w5));
                byte[] gelenResimByte = cursor.getBlob(w6);
                Bitmap gelenResim = BitmapFactory.decodeByteArray(gelenResimByte, 0, gelenResimByte.length);
                sellResimList.add(gelenResim);
            }
            cursor.close();
            for (int i=0;i<addList.size();i++){
                System.out.println("buraya geldi SELL");
                Sell_java sell_java = new Sell_java();
                sell_java.setAdd(addList.get(i));
                sell_java.setAdress(adressList.get(i));
                sell_java.setEmaill(emaillList.get(i));
                sell_java.setNotee(noteeList.get(i));
                sell_java.setPhonee(phoneeList.get(i));
                sell_java.setSellResim(sellResimList.get(i));

                sellList.add(sell_java);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("returnselllist"+sellList);
        return sellList;
    }
}

