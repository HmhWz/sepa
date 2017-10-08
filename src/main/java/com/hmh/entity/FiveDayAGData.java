package com.hmh.entity;

public class FiveDayAGData {
    private int num;
    private String retCode;
    private String retDesc;
    private String version;
    private AGDayData[] ret;

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc;
    }

    public String getRetDesc() {
        return retDesc;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setRet(AGDayData[] ret) {
        this.ret = ret;
    }

    public AGDayData[] getRet() {
        return ret;
    }
}
