package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class profil extends AppCompatActivity {
EditText et;
ImageButton imBU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        et =findViewById(R.id.h);

        Intent i =getIntent();
        String gelen =i.getStringExtra("name");
        et.setText(gelen);

        imBU=findViewById(R.id.imageButton);
        imBU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profil.this, Massegler.class);
                startActivity(intent);
            }
        });
    }
}