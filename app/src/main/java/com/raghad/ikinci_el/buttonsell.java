package com.raghad.ikinci_el;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class buttonsell extends AppCompatActivity {
    EditText e10,e11,e12,e13,e14;
    int imgIzınAlmaKodu = 0, imgIzınAlaKodu = 1;
    Button b;

    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonsell);
        DBHelper db= new DBHelper(this);
        e10=findViewById(R.id.e10);
        e11=findViewById(R.id.e11);
        e12=findViewById(R.id.e12);
        e13=findViewById(R.id.e14);
        e14=findViewById(R.id.e14);

        b=findViewById(R.id.save);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.VeriEkle1(e10.getText().toString(),e11.getText().toString(),e12.getText().toString(),e13.getText().toString(),e14.getText().toString());
                Toast.makeText(buttonsell.this, "Save Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void resimSec(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, imgIzınAlmaKodu);

        } else {
            Intent resimAL = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(resimAL, imgIzınAlaKodu);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == imgIzınAlmaKodu) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent resimAL = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(resimAL, imgIzınAlaKodu);
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}