package com.raghad.ikinci_el;

public class User {
    int userid;
    String username;
    String pasword;
    String adress;
    String phone;

    public User(int userid,String username, String pasword, String adress, String phone) {
        this.userid= userid;
        this.username = username;
        this.pasword = pasword;
        this.adress = adress;
        this.phone = phone;
    }
    public  User(){}

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPasword() {
        return pasword;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
