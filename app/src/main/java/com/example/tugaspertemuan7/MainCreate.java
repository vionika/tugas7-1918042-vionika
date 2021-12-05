package com.example.tugaspertemuan7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends Activity {
    private MyDatabase db;
    private EditText Emerk, Ejenis, Eharga;
    private String Smerk, Sjenis, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Emerk = (EditText) findViewById(R.id.create_merk);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Smerk = String.valueOf(Emerk.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi merk kopi ",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis kopi ",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi harga kopi ",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Emerk.setText("");
                    Ejenis.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateKopi (new Kopi(null, Smerk,
                            Sjenis, Sharga));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
