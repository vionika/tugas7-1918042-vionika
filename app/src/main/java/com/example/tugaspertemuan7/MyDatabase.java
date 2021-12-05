package com.example.tugaspertemuan7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_kopi";
    private static final String tb_kopi = "tb_kopi";
    private static final String tb_kopi_id = "id";
    private static final String tb_kopi_merk = "merk";
    private static final String tb_kopi_jenis = "jenis";
    private static final String tb_kopi_harga = "harga";
    private static final String CREATE_TABLE_KOPI = "CREATE TABLE " + tb_kopi + "("
            + tb_kopi_id+ " INTEGER PRIMARY KEY ,"
            + tb_kopi_merk + " TEXT,"
            + tb_kopi_jenis + " TEXT,"
            + tb_kopi_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KOPI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateKopi (Kopi mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kopi_id, mdNotif.get_id());
        values.put(tb_kopi_merk, mdNotif.get_merk());
        values.put(tb_kopi_jenis, mdNotif.get_jenis());
        values.put(tb_kopi_harga, mdNotif.get_harga());
        db.insert(tb_kopi, null, values);
        db.close();
    }
    public List<Kopi> ReadKopi() {
        List<Kopi> judulModelList = new ArrayList<Kopi>();
        String selectQuery = "SELECT * FROM " + tb_kopi;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Kopi mdKontak = new Kopi();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_merk(cursor.getString(1));
                mdKontak.set_jenis(cursor.getString(2));
                mdKontak.set_harga(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateKopi (Kopi mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kopi_merk, mdNotif.get_merk());
        values.put(tb_kopi_jenis, mdNotif.get_jenis());
        values.put(tb_kopi_harga, mdNotif.get_harga());
        return db.update(tb_kopi, values, tb_kopi_id + " = ?",
                new String[] {
                        String.valueOf(mdNotif.get_id())});
    }
    public void DeleteKopi (Kopi mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_kopi, tb_kopi_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}