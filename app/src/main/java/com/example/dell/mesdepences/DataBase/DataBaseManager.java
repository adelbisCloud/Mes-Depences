package com.example.dell.mesdepences.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.example.dell.mesdepences.DataBase.DataBaseManager.MesDepences.DESCRIPTION;
import static com.example.dell.mesdepences.DataBase.DataBaseManager.MesDepences.TABLE;
import static com.example.dell.mesdepences.DataBase.DataBaseManager.MesDepences._ID;

/**
 * Created by DELL on 03/10/2017.
 */

public class DataBaseManager extends SQLiteOpenHelper {

    private static final String CREAT_TABLE="CREATE TABLE "+TABLE+" ( "+_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + DESCRIPTION +"  TEXT) " ;
    private static final String DATA_BASE_NAME = "Gestion_MesDepences";
    private static final int VERSION = 1;

    public DataBaseManager(Context context) {
        super(context, DATA_BASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        db.execSQL(CREAT_TABLE);

    }
    public boolean insertData(String des) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DESCRIPTION,des);
        long result = db.insert(TABLE,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public ArrayList getAllData(){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =db.rawQuery("SELECT * FROM "+ TABLE, null);
        res.moveToFirst();
        while (res.isAfterLast()== false){
            String s1=res.getString(0);
            String s2=res.getString(1);
            arrayList.add("id = "+ s1 +" Description = "+ s2);
            res.moveToNext();

        }
        return arrayList;


    }



    public static class MesDepences {
        public static final String TABLE = "Depences";
        public static final String _ID = "_id";
        public static final String DESCRIPTION = "description";
        private String description;


    }
}
