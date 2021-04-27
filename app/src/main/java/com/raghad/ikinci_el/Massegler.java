package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Massegler extends AppCompatActivity {
    TextView t1,t2,t3;
    DBHelper DB;
    Context context =this;
    List<String> veriler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massegler);
        final ListView L1;
        L1 =findViewById(R.id.gonderilen);

        DB = new DBHelper(this);
        veriler = DB.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Massegler.this, android.R.layout.simple_list_item_1, android.R.id.text1, veriler);
        L1.setAdapter(adapter);
    }
}