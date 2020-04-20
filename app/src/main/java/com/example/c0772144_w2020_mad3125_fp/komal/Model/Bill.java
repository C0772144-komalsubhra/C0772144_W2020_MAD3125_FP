package com.example.c0772144_w2020_mad3125_fp.komal.Model;

import org.joda.time.LocalDate;

import java.io.Serializable;

public class Bill implements Serializable {

    public enum BillType {
        Mobile,
        Hydro,
        Internet,
    }
    String billId;
    LocalDate billDate;
    BillType billType;
    Double billTotal = 0.0;

    Bill(String billId, LocalDate billDate, BillType billType)
    {
        this.billId = billId;
        this.billDate = billDate;
        this.billType = billType;
    }

    public Double billCalculate(){
        double dummyAmount = 0.0;
        return dummyAmount;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public Double getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(Double billTotal) {
        this.billTotal = billTotal;
    }
}

