package com.raghad.ikinci_el;

public class Picture {
    int pictureid;
    String picturePath;

    public Picture(){}

    public Picture(int pictureid, String picturePath) {
        this.pictureid = pictureid;
        this.picturePath = picturePath;
    }

    public int getPictureid() {
        return pictureid;
    }

    public void setPictureid(int pictureid) {
        this.pictureid = pictureid;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
