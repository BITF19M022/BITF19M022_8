package com.usman.madrasafaizululoom.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.usman.madrasafaizululoom.model.Record;
import com.usman.madrasafaizululoom.model.Students;
import com.usman.madrasafaizululoom.params.Parameters;

import java.util.ArrayList;
import java.util.List;

public class RecordDBHandler extends SQLiteOpenHelper {
    public RecordDBHandler(Context context)
    {
        super(context, Parameters.DB_NAME, null, Parameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + Parameters.RECORD_TABLE_NAME + "("
                + Parameters.KEY_RECORD_ID + " PRIMARY KEY AUTOINCREMENT,"
                + Parameters.KEY_DATE + " TEXT,"
                + Parameters.KEY_SABAQ + " TEXT,"
                + Parameters.KEY_SABQI + " TEXT,"
                + Parameters.KEY_MANZIL + " INTEGER,"
                + Parameters.KEY_FK_ID + " INTEGER,"
                + "FOREIGN KEY (" + Parameters.KEY_FK_ID +")\n" +
                "  REFERENCES departments(" + Parameters.KEY_ID +")"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addRecord(Record obj)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(Parameters.KEY_DATE, obj.getDateOfToday());
        value.put(Parameters.KEY_SABAQ, obj.getSabaq());
        value.put(Parameters.KEY_SABQI, obj.getSabqi());
        value.put(Parameters.KEY_MANZIL, obj.getManzil());
        value.put(Parameters.KEY_FK_ID, obj.getStdID());

        db.insert(Parameters.RECORD_TABLE_NAME, null, value);
        db.close();
    }

    public List<Record> getAllRecord()
    {
        List<Record> recordList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " +  Parameters.RECORD_TABLE_NAME;
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do {
                Record recordObj = new Record();
                recordObj.setRecordId(Integer.parseInt(cursor.getString(0)));
                recordObj.setDateOfToday(cursor.getString(1));
                recordObj.setSabaq(cursor.getString(2));
                recordObj.setSabqi(cursor.getString(3));
                recordObj.setManzil(cursor.getString(4));
                recordObj.setStdID(Integer.parseInt(cursor.getString(5)));
                recordList.add(recordObj);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return recordList;
    }
}
