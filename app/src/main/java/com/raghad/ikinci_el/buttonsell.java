package com.raghad.ikinci_el;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class buttonsell extends AppCompatActivity {
    ImageView imageResim;
    private Bitmap secilenresim;
    EditText e10, e11, e12, e13, e14;
    int imgIzınAlmaKodu = 0, imgIzınAlaKodu = 1;
    Button b;

    Context context = this;
    Bitmap kucultulenResim,enbastakıResım;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonsell);
        DBHelper db = new DBHelper(this);
        e10 = findViewById(R.id.e10);
        e11 = findViewById(R.id.e11);
        e12 = findViewById(R.id.e12);
        e13 = findViewById(R.id.e14);
        e14 = findViewById(R.id.e14);
        imageResim = findViewById(R.id.imageView6);

        b = findViewById(R.id.save);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
                kucultulenResim = resimKucult(secilenresim);
                secilenresim.compress(Bitmap.CompressFormat.PNG,75, outputStream);
                byte[] kayitEdilecekRseim = outputStream.toByteArray();
                try {
                    db.VeriEkle1(e10.getText().toString(), e11.getText().toString(), e12.getText().toString(), e13.getText().toString(), e14.getText().toString(),kayitEdilecekRseim);
                }catch (Exception e){
                    e.printStackTrace();
                }
                nesnelerıTemızle();
                Toast.makeText(buttonsell.this, "Save Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private  void nesnelerıTemızle(){
        e10.setText("");
        e11.setText("");
        e12.setText("");
        e13.setText("");
        e14.setText("");
        enbastakıResım = BitmapFactory.decodeResource(this.getResources(),R.drawable.pp);
        imageResim.setImageBitmap(enbastakıResım);

    }
    private Bitmap resimKucult(Bitmap resim){
        return Bitmap.createScaledBitmap(resim,70,70,true);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == imgIzınAlaKodu)) {
            if (resultCode == RESULT_OK && data != null) {
                Uri resimUri = data.getData();

                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        ImageDecoder.Source resimSOURc = ImageDecoder.createSource(this.getContentResolver(), resimUri);
                        secilenresim = ImageDecoder.decodeBitmap(resimSOURc);
                        imageResim.setImageBitmap(secilenresim);
                    } else {
                        secilenresim = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resimUri);
                        imageResim.setImageBitmap(secilenresim);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
