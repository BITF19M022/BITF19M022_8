package com.usman.madrasafaizululoom.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.usman.madrasafaizululoom.params.Parameters;

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
}
