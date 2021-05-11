package com.raghad.ikinci_el;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class sell extends AppCompatActivity {
    TextView t1,t2,t3;
    static  public DBHelper DB;
    ImageView vv;
    List<String> veriler1;
    private RecyclerView mReclerView;
    private sellAdepter adapter;
    static  public  SellDetay sellDetay;
    static  public  Sell_java sell_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);
        System.out.println("sell sayfasındayım");
        mReclerView =(RecyclerView)findViewById(R.id.main_activity_recyclerView);
        adapter = new sellAdepter(sell_java.getData(this),this);
        System.out.println(Sell_java.getData(this));
        mReclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mReclerView.setLayoutManager(manager);
        mReclerView.setAdapter(adapter);

        adapter.setOnItemClıckLıstener(new sellAdepter.OnItemClickListener() {
            @Override
            public void onItemClıck(Sell_java sell_java) {
                sellDetay =new SellDetay(sell_java.getAdd(),sell_java.getPhonee(),sell_java.getAdress(),sell_java.getNotee(),sell_java.getEmaill(),sell_java.getSellResim());
                Intent intent = new Intent(sell.this,icerikler.class);
                startActivity(intent);
             }
        });




        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        //vv =findViewById(R.id.mm);
//        Bitmap d=vv.getDrawingCache();
  //      DB =new DBHelper(this);
       // d = DB.VeriListelephoto(d);
        //vv.setImageBitmap(d);

//        vv.setOnClickListener(new View.OnClickListener() {
 //           @Override
  //          public void onClick(View v) {
   //         Intent intent = new Intent(sell.this,icerikler.class);
     //       startActivity(intent);
       //     }
        //});


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