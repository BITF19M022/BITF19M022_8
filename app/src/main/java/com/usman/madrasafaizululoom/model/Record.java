package com.usman.madrasafaizululoom.model;

public class Record {
    public int RecordId;
    public String DateOfToday;
    public String Sabaq;
    public String Sabqi;
    public String Manzil;
    public int StdID;

    public Record() {
    }

    public Record(int recordId, String dateOfToday, String sabaq, String sabqi, String manzil, int stdID) {
        RecordId = recordId;
        DateOfToday = dateOfToday;
        Sabaq = sabaq;
        Sabqi = sabqi;
        Manzil = manzil;
        StdID = stdID;
    }

    public Record(String dateOfToday, String sabaq, String sabqi, String manzil, int stdID) {
        DateOfToday = dateOfToday;
        Sabaq = sabaq;
        Sabqi = sabqi;
        Manzil = manzil;
        StdID = stdID;
    }


    public String getDateOfToday() {
        return DateOfToday;
    }

    public void setDateOfToday(String dateOfToday) {
        DateOfToday = dateOfToday;
    }

    public String getSabaq() {
        return Sabaq;
    }

    public void setSabaq(String sabaq) {
        Sabaq = sabaq;
    }

    public String getSabqi() {
        return Sabqi;
    }

    public void setSabqi(String sabqi) {
        Sabqi = sabqi;
    }

    public String getManzil() {
        return Manzil;
    }

    public void setManzil(String manzil) {
        Manzil = manzil;
    }

    public int getRecordId() {
        return RecordId;
    }

    public void setRecordId(int recordId) {
        RecordId = recordId;
    }

    public int getStdID() {
        return StdID;
    }

    public void setStdID(int stdID) {
        StdID = stdID;
    }

    public String toString() {
        return "\nSabaq \t" + getSabaq() + "\nSabqi \t" + getSabqi() + "\nManzil \t\t" + getManzil() + "\n";
    }
}
