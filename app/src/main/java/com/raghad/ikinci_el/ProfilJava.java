package com.raghad.ikinci_el;

public class ProfilJava {
    String name;
    String surname;
    String date;
    String gender;
    String email;
    String phone;
    String adress;

    public ProfilJava() {
    }

    public ProfilJava(String name, String surname, String date, String gender, String email, String phone, String adress) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
