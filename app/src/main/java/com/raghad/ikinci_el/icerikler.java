package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class icerikler extends AppCompatActivity {
    Context context =this;
    List<String> veriler1;
    DBHelper DB;
    TextView ic1,ic2,ic3,ic4,ic5;
    ImageView icview;
    Button btnsil,btngun;
    String addtext;
    String phoneetext;
    String emailltext;
    String noteetext;
    String adresstext;
    Bitmap sellResimimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerikler);
        icview = findViewById(R.id.icerik_activity_imageViewsellResim);
        ic1=findViewById(R.id.d1);
        ic2=findViewById(R.id.detay2);
        ic3=findViewById(R.id.detay3);
        ic4=findViewById(R.id.detay4);
        ic5=findViewById(R.id.detay5);
        btnsil=findViewById(R.id.sil);
        btngun=findViewById(R.id.guncele1);


        addtext =sell.sellDetay.getAdd();
        phoneetext=sell.sellDetay.getPhonee();
        emailltext=sell.sellDetay.getEmaill();
        noteetext=sell.sellDetay.getNotee();
        adresstext=sell.sellDetay.getAdress();
        sellResimimage=sell.sellDetay.getSellResim();


        ic1.setText(addtext);
        ic2.setText(phoneetext);
        ic3.setText(emailltext);
        ic4.setText(noteetext);
        ic5.setText(adresstext);
        icview.setImageBitmap(sellResimimage);






        btnsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             try {
                 DB =new DBHelper(context);
                 DB.deleteSell(ic1.getText().toString());
                 Toast.makeText(getApplicationContext(),"İlanınız silindi",Toast.LENGTH_LONG).show();
                 Intent intent= new Intent(icerikler.this,sell.class);
                 startActivity(intent);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        });
        btngun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(icerikler.this,guncelee.class);
                startActivity(intent);
            }
        });


}






}