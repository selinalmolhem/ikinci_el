package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class guncelee extends AppCompatActivity {
Button btngunc;
    Context context =this;
    List<String> veriler1;
    DBHelper DB;
    EditText ic1,ic2,ic3,ic4,ic5;
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
        setContentView(R.layout.activity_guncelee);

        ic1=findViewById(R.id.d1);
        ic2=findViewById(R.id.d2);
        ic3=findViewById(R.id.d3);
        ic4=findViewById(R.id.d4);
        ic5=findViewById(R.id.d5);
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
//        icview.setImageBitmap(sellResimimage);



        btngunc= findViewById(R.id.guncele1);
        btngunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
                sellResimimage.compress(Bitmap.CompressFormat.PNG,75, outputStream);
                byte[] kayitEdilecekRseim = outputStream.toByteArray();
                try {
                    DB =new DBHelper(context);
                    DB.updatasell(ic1.getText().toString(),ic2.getText().toString(),ic3.getText().toString(),ic4.getText().toString(),ic5.getText().toString(),kayitEdilecekRseim);
                    Toast.makeText(getApplicationContext(),"İlanınız guncelendi",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(guncelee.this,sell.class);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}