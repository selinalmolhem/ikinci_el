package com.raghad.ikinci_el;

public class Tool {
    int toolid;
    String toolname;
    String text;
    boolean state;
    public Tool(){}
    public Tool(int toolid, String toolname, String text, boolean state) {
        this.toolid = toolid;
        this.toolname = toolname;
        this.text = text;
        this.state = state;
    }

    public int getToolid() {
        return toolid;
    }

    public void setToolid(int toolid) {
        this.toolid = toolid;
    }

    public String getToolname() {
        return toolname;
    }

    public void setToolname(String toolname) {
        this.toolname = toolname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
