package com.example.c0772144_w2020_mad3125_fp.komal.Model;

import org.joda.time.LocalDate;

public class Internet extends Bill {
    private String providerName;
    private Double gbUsed;

    public Internet(String billId, LocalDate billDate, BillType billType, String providerName, Double gbUsed)
    {
        super(billId, billDate, billType);
        this.providerName = providerName;
        this.gbUsed = gbUsed;
        this.billTotal = billCalculate();
    }

    @Override
    public Double billCalculate(){
        double billAmount = 0.0;
        if( gbUsed < 10){
            billAmount = 3 * gbUsed;
        }
        else {
            billAmount = 3.5 * gbUsed;
        }
        return billAmount;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Double getGbUsed() {
        return gbUsed;
    }

    public void setGbUsed(Double gbUsed) {
        this.gbUsed = gbUsed;
    }
}


