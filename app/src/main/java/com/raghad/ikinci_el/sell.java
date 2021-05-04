package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class sell extends AppCompatActivity {
TextView t1,t2,t3;
    DBHelper DB;
    ImageView vv;
    Context context =this;
    List<String> veriler1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        vv =findViewById(R.id.mm);
        Bitmap d=vv.getDrawingCache();
        DB =new DBHelper(this);
        d = DB.VeriListelephoto(d);
        vv.setImageBitmap(d);

        vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(sell.this,icerikler.class);
            startActivity(intent);
            }
        });


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

    }
}