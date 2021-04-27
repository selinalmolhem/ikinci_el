package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class buylistview extends AppCompatActivity {
EditText e1,e2,e3,e4,e5;
Button save;
ImageView im;
Context context =this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buylistview);
        e1=findViewById(R.id.e14);
        e5=findViewById(R.id.e5);
        e4=findViewById(R.id.e4);
        e3=findViewById(R.id.e3);
        e2=findViewById(R.id.e2);
        save=findViewById(R.id.save);
        DBHelper db= new DBHelper(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.VeriEkle(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString());
                Toast.makeText(buylistview.this, "Send Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent ( buylistview.this ,buy.class);
                startActivity(intent);
            }
        });

    }

    }
