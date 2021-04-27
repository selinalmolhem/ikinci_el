package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class sell extends AppCompatActivity {
TextView t1,t2,t3;
DBHelper DB;
    Context context =this;
    List<String> veriler1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sell.this, profil.class);
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sell.this, buy.class);
                startActivity(intent);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sell.this, buttonsell.class);
                startActivity(intent);
            }
        });
        final ListView L1;
        L1 =findViewById(R.id.seller1);

        DB = new DBHelper(this);
        veriler1 = DB.VeriListele1();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(sell.this, android.R.layout.simple_list_item_1, android.R.id.text1, veriler1);
        L1.setAdapter(adapter);
    }
}