package com.example.tugaspertemuan7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Kopi> ListKopi = new ArrayList<Kopi>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListKopi );
        mListView = (ListView) findViewById(R.id.list_kopi);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListKopi.clear();
        List<Kopi> contacts = db.ReadKopi();
        for (Kopi cn : contacts) {
            Kopi tokokopi = new Kopi();
            tokokopi.set_id(cn.get_id());
            tokokopi.set_merk(cn.get_merk());
            tokokopi.set_jenis(cn.get_jenis());
            tokokopi.set_harga(cn.get_harga());
            ListKopi.add(tokokopi);
            if ((ListKopi.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Kopi obj_itemDetails = (Kopi) o;
        String Sid = obj_itemDetails.get_id();
        String Smerk = obj_itemDetails.get_merk();
        String Sjenis = obj_itemDetails.get_jenis();
        String Sharga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Imerk", Smerk);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListKopi.clear();
        mListView.setAdapter(adapter_off);
        List<Kopi> contacts = db.ReadKopi();
        for (Kopi cn : contacts) {
            Kopi tokokopi = new Kopi();
            tokokopi.set_id(cn.get_id());
            tokokopi.set_merk(cn.get_merk());
            tokokopi.set_jenis(cn.get_jenis());
            tokokopi.set_harga(cn.get_harga());
            ListKopi.add(tokokopi);
            if ((ListKopi.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
