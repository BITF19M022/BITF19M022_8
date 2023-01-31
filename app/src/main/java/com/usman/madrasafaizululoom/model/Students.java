package com.usman.madrasafaizululoom.model;

public class Students {
    private int stdID;
    private String stdName;
    private String stdPhoneNo;
    private String stdCity;

    public Students() {
        // do nothing
    }

    public Students(String stdName, String stdPhoneNo, String stdSalary) {
        this.stdName = stdName;
        this.stdPhoneNo = stdPhoneNo;
        this.stdCity = stdSalary;
    }

    public Students(int stdID, String stdName, String stdPhoneNo, String stdSalary) {
        this.stdID = stdID;
        this.stdName = stdName;
        this.stdPhoneNo = stdPhoneNo;
        this.stdCity = stdSalary;
    }


    public int getStdID() {
        return stdID;
    }

    public void setStdID(int stdID) {
        this.stdID = stdID;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdPhoneNo() {
        return stdPhoneNo;
    }

    public void setStdPhoneNo(String stdPhoneNo) {
        this.stdPhoneNo = stdPhoneNo;
    }

    public String getStdCity() {
        return stdCity;
    }

    public void setStdCity(String stdSalary) {
        this.stdCity = stdSalary;
    }

    public String toString() {
        return "\nName \t" + stdName + "\nPhone \t" + stdPhoneNo + "\nCity \t\t" + stdCity + "\n";
    }

}
