package com.example.c0772144_w2020_mad3125_fp.komal.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

class Customer implements Parcelable {

    private String customerId;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String userName;
    private String password;
    private String location;
    private String dateOfBirth;
    private HashMap<String, Bill> customerBillsHashMap = new HashMap<String, Bill>();
    private Double allTotal;
    private int customerImg;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenderLetter()
    {
        return getGender().substring(0,1).toUpperCase();
    }

    protected Customer(Parcel in) {
        customerId = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        gender = in.readString();
        email = in.readString();
        userName = in.readString();
        password = in.readString();
        location = in.readString();
        dateOfBirth = in.readString();
        customerBillsHashMap = in.readHashMap(Bill.class.getClassLoader());
        allTotal = in.readDouble();
        customerImg = in.readInt();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public int getCustomerImg() {
        return customerImg;
    }

    public Customer (String customerId,
                     String firstName,
                     String lastName,
                     String gender,
                     String email,
                     String userName,
                     String password,
                     String location,
                     String dateOfBirth,
                     Integer customerImg)
    {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.dateOfBirth = dateOfBirth;
        this.customerImg = customerImg;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addBill(String billId, Bill bill)
    {
        this.customerBillsHashMap.put(billId, bill);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public HashMap<String, Bill> getCustomerBills() {
        return customerBillsHashMap;
    }

    public void setCustomerBills(HashMap<String, Bill> customerBills) {
        this.customerBillsHashMap = customerBills;
    }

    public Double getAllTotal() {
        return allTotal;
    }

    public void setAllTotal(Double allTotal) {
        this.allTotal = allTotal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerId);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(gender);
        dest.writeString(email);
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeString(location);
        dest.writeString(dateOfBirth);
        dest.writeMap(customerBillsHashMap);
        if (allTotal == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(allTotal);
        }
        dest.writeInt(customerImg);
    }

    public ArrayList<Bill> getBills()
    {
        Collection<Bill> demoValues = customerBillsHashMap.values();
        ArrayList<Bill> billsList = new ArrayList<>(demoValues);
        return billsList;
    }

    public double getTotalAmount()
    {
        double allTotal2 = 0.0d;
        for (Bill b : customerBillsHashMap.values())
        {
            allTotal2 += b.billTotal;
        }
        return allTotal2;
    }
}



