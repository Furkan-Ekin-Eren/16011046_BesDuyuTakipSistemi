package com.example.asdf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class veriTabani extends SQLiteOpenHelper {
    private static final String DATABASE_NAME   ="Sirket";
    private static final String TABLE_CUSTOMER   ="Customers";
    private static final String TABLE_MEDİA   ="Medias";

    public veriTabani(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_CUSTOMER + "(id INTEGER PRIMARY KEY autoincrement,ad TEXT,soyAd TEXT,telNo TEXT,eMail TEXT,tc TEXT,cusUri TEXT,cusImage INTEGER" + ")";
        String sql2 = "CREATE TABLE " + TABLE_MEDİA + "(id INTEGER PRIMARY KEY autoincrement,ad TEXT,mediaId TEXT,eMail TEXT,telNo TEXT,type TEXT,medUri TEXT,medImage INTEGER" + ")";
        db.execSQL(sql);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDİA);
        onCreate(db);
    }

    public void insertCustomer(customer cus){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("ad",cus.getAd());
        values.put("soyAd",cus.getSoyAd());
        values.put("telNo",cus.getTelNo());
        values.put("eMail",cus.geteMail());
        values.put("tc",cus.getTc());
        values.put("cusUri",cus.getCusUri());
        values.put("cusImage",cus.getCusImage());
        db.insert(TABLE_CUSTOMER , null, values);
        db.close();
    }

    public ArrayList<customer> getAllCustomers(){
        ArrayList<customer> Custos = new ArrayList<customer>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CUSTOMER, new String[]{"id", "ad", "soyAd","telNo","eMail","tc","cusUri","cusImage"}, null, null, null, null, null);
        while (cursor.moveToNext()){
            customer cus = new customer();
            cus.setAd(cursor.getString(1));
            cus.setSoyAd(cursor.getString(2));
            cus.setTelNo(cursor.getString(3));
            cus.seteMail(cursor.getString(4));
            cus.setTc(cursor.getString(5));
            cus.setCusUri(cursor.getString(6));
            cus.setCusImage(cursor.getInt(7));
            Custos.add(cus);
        }
        return Custos;
    }

    public void insertMedia(media med){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("ad",med.getAd());
        values.put("mediaId",med.getMediaId());
        values.put("eMail",med.geteMail());
        values.put("telNo",med.getTelNo());
        values.put("type",med.getType());
        values.put("medUri",med.getMedUri());
        values.put("medImage",med.getMedImage());
        db.insert(TABLE_MEDİA, null, values);
        db.close();
    }

    public ArrayList<media> getAllMedias(){
        ArrayList<media> Medias = new ArrayList<media>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_MEDİA, new String[]{"id", "ad", "mediaId","eMail","telNo","type","medUri","medImage"}, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.moveToNext()){
            media med = new media();
            med.setAd(cursor.getString(1));
            med.setMediaId(cursor.getString(2));
            med.seteMail(cursor.getString(3));
            med.setTelNo(cursor.getString(4));
            med.setType(cursor.getString(5));
            med.setMedUri(cursor.getString(6));
            med.setMedImage(cursor.getInt(7));
            Medias.add(med);
        }
        return Medias;
    }


}
