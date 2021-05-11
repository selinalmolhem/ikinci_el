package com.raghad.ikinci_el;

import android.graphics.Bitmap;

public class SellDetay {
    String add;
    String phonee;
    String emaill;
    String notee;
    String adress;
    Bitmap sellResim;

    public SellDetay(String add, String phonee, String emaill, String notee, String adress, Bitmap sellResim) {
        this.add = add;
        this.phonee = phonee;
        this.emaill = emaill;
        this.notee = notee;
        this.adress = adress;
        this.sellResim = sellResim;
    }

    public SellDetay() {
    }

    public String getAdd() {
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

    public Bitmap getSellResim() {
        return sellResim;
    }

    public void setSellResim(Bitmap sellResim) {
        this.sellResim = sellResim;
    }
}
