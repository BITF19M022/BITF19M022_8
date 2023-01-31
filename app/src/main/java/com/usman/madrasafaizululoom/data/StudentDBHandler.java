package com.usman.madrasafaizululoom.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.usman.madrasafaizululoom.model.Students;
import com.usman.madrasafaizululoom.params.Parameters;

import java.util.ArrayList;
import java.util.List;


public class StudentDBHandler extends SQLiteOpenHelper {
    public StudentDBHandler(Context context)
    {
        super(context, Parameters.DB_NAME, null, Parameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + Parameters.STUDENT_TABLE_NAME + "("
                + Parameters.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Parameters.KEY_NAME + " TEXT,"
                + Parameters.KEY_PHONE + " TEXT,"
                + Parameters.KEY_CITY + " TEXT,"
                + Parameters.KEY_IMAGE + " INTEGER"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent(Students std)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(Parameters.KEY_NAME, std.getStdName());
        value.put(Parameters.KEY_PHONE, std.getStdPhoneNo());
        value.put(Parameters.KEY_CITY, std.getStdCity());

        db.insert(Parameters.STUDENT_TABLE_NAME, null, value);
        db.close();
    }

    public List<Students> getAllStudent()
    {
        List<Students> empList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " +  Parameters.STUDENT_TABLE_NAME;
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst())
        {
            do {
                Students std = new Students();
                std.setStdID(Integer.parseInt(cursor.getString(0)));
                std.setStdName(cursor.getString(1));
                std.setStdPhoneNo(cursor.getString(2));
                std.setStdCity(cursor.getString(3));
                empList.add(std);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return empList;
    }
}
