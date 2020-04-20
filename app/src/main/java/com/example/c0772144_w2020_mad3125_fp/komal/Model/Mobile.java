package com.example.c0772144_w2020_mad3125_fp.komal.Model;

import org.joda.time.LocalDate;

public class Mobile extends Bill{
    String manufacturerName;
    String planName;
    String mobileNumber;
    Integer mobGbUsed;
    Integer minute;

    public Mobile(String billId, LocalDate billDate, BillType billType, String manufacturerName, String planName, String mobileNumber, Integer mobGbUsed, Integer minute){
        super(billId, billDate, billType);
        this.manufacturerName = manufacturerName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.mobGbUsed = mobGbUsed;
        this.minute = minute;
        this.billTotal = billCalculate();
    }

    //Overriding default implementation of billCalculate in Bill class
    @Override
    public Double billCalculate(){
        double billAmount = 0.0;
        billAmount = (this.mobGbUsed) * 25 + (this.minute) * 0.2;
        return billAmount;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getMobGbUsed() {
        return mobGbUsed;
    }

    public void setMobGbUsed(Integer mobGbUsed) {
        this.mobGbUsed = mobGbUsed;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }
}

}
