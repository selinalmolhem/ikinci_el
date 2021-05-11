package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class buy extends AppCompatActivity {
TextView t1,t2,t3;
    static  public DBHelper DB;
    Context context =this;
    List<String> veriler;
    private RecyclerView mReclerView;
    private sellAdepter adapter;
    static  public  SellDetay sellDetay;
    static  public  Sell_java sell_java;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);



        System.out.println("buy sayfasındayım");
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
                Intent intent = new Intent(buy.this,buylistview.class);
                startActivity(intent);
            }
        });




        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buy.this, profil.class);
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buy.this,buylistview.class);
                startActivity(intent);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(buy.this, sell.class);
                startActivity(intent);
            }
        });
        final ListView L1;
//        L1 =findViewById(R.id.seller1);

  //      DB = new DBHelper(this);
     // veriler = DB.VeriListele1();
 //      ArrayAdapter<String> adapter = new ArrayAdapter<String>(buy.this, android.R.layout.simple_list_item_1, android.R.id.text1, veriler);
  //     L1.setAdapter(adapter);
    }
}