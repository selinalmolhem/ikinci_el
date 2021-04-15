package com.raghad.ikinci_el;

public class ToolType {
    int tooltypeid;
    String tooltypename;

    public ToolType(int tooltypeid, String tooltypename) {
        this.tooltypeid = tooltypeid;
        this.tooltypename = tooltypename;
    }
    public ToolType(){}

    public int getTooltypeid() {
        return tooltypeid;
    }

    public void setTooltypeid(int tooltypeid) {
        this.tooltypeid = tooltypeid;
    }

    public String getTooltypename() {
        return tooltypename;
    }

    public void setTooltypename(String tooltypename) {
        this.tooltypename = tooltypename;
    }
}
