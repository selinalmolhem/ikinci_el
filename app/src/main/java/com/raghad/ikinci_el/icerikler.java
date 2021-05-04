package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class icerikler extends AppCompatActivity {
    Context context =this;
    List<String> veriler1;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerikler);
        final ListView L1;
        L1 =findViewById(R.id.seller);

        DB = new DBHelper(this);
        veriler1 = DB.VeriListele1();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(icerikler.this, android.R.layout.simple_list_item_1, android.R.id.text1, veriler1);
        L1.setAdapter(adapter);
    }
}