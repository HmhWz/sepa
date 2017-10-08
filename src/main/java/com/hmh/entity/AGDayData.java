package com.hmh.entity;

public class AGDayData {

    private String wareName;
    private float lastClosePrice;
    private Object[][] data;

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getWareName() {
        return wareName;
    }

    public void setLastClosePrice(float lastClosePrice) {
        this.lastClosePrice = lastClosePrice;
    }

    public float getLastClosePrice() {
        return lastClosePrice;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public Object[][] getData() {
        return data;
    }
}
