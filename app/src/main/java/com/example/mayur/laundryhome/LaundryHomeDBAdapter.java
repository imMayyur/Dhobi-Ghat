package com.example.mayur.laundryhome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LaundryHomeDBAdapter {
    private static final String DB_NAME = "LaundryDB";
    private static final int DB_VERSION = 3;

    private static LaundryHomeDBAdapter laundryHomeDBAdapter;
    private Context context;

    private SQLiteDatabase sqLiteDatabase;

    public static final String USER_TABLE_NAME = "users";
    public static final String USER_COL_ID = "_id";
    public static final String USER_COL_UNAME = "U_Name";
    public static final String USER_COL_UMNO = "U_Mno";
    public static final String USER_COL_UADD = "U_Add";
    private static final String CREATE_TABLE_USER = "create table " + USER_TABLE_NAME +
            "(" + USER_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + USER_COL_UNAME + " TEXT,"
            + USER_COL_UMNO + " TEXT,"
            + USER_COL_UADD + " TEXT" +
            ");";


    public LaundryHomeDBAdapter(Context context) {
        LaundrySQLiteOpenHelper laundrySQLiteOpenHelper = new LaundrySQLiteOpenHelper(context, DB_NAME, null, DB_VERSION);
        sqLiteDatabase = laundrySQLiteOpenHelper.getWritableDatabase();
    }

    public static LaundryHomeDBAdapter getInstance(Context context) {
        if (laundryHomeDBAdapter == null) {
            laundryHomeDBAdapter = new LaundryHomeDBAdapter(context);
            return laundryHomeDBAdapter;
        }
        return laundryHomeDBAdapter;
    }

    private static class LaundrySQLiteOpenHelper extends SQLiteOpenHelper {
        public LaundrySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE_USER);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            if(i==2 && i1==3) {
                sqLiteDatabase.execSQL("Drop table " + USER_TABLE_NAME);
                sqLiteDatabase.execSQL(CREATE_TABLE_USER);
            }
        }
    }

    public boolean insertData(Users users) {
        ContentValues cv = new ContentValues();
        cv.put(USER_COL_UNAME, users.getU_name());
        cv.put(USER_COL_UMNO, users.getU_mno());
        cv.put(USER_COL_UADD, users.getU_add());

        return (sqLiteDatabase.insert(USER_TABLE_NAME, null, cv) > 0);
    }


    public Cursor getAllRecord() {
        Cursor cursor = null;
        cursor = sqLiteDatabase.query(USER_TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }
}
