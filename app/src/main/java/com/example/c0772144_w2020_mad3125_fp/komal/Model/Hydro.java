package com.example.c0772144_w2020_mad3125_fp.komal.Model;

import org.joda.time.LocalDate;

public class Hydro extends Bill{
    private String name;
    private Integer unitsUsed;

    public Hydro(String billId, LocalDate billDate, BillType billType, String agencyName, Integer unitsUsed){
        super(billId, billDate, billType);
        this.agencyName = agencyName;
        this.unitsUsed = unitsUsed;
        this.billTotal = billCalculate();
    }

    @Override
    public Double billCalculate(){
        double billAmount = 0.0;
        if (unitsUsed < 10)
        {
            billAmount = 1.5 * unitsUsed;
        }
        else
        {
            billAmount = 2 * unitsUsed;
        }
        return billAmount;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public Integer getUnitsUsed() {
        return unitsUsed;
    }

    public void setUnitsUsed(Integer unitsUsed) {
        this.unitsUsed = unitsUsed;
    }

}


