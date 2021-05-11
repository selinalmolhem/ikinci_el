package com.raghad.ikinci_el;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class sellAdepter extends RecyclerView.Adapter<sellAdepter.seelHolder> {

    private ArrayList<Sell_java> sellList;
    private OnItemClickListener listener;
    Context context;

    public sellAdepter(ArrayList<Sell_java> sellList, Context context) {
        this.sellList = sellList;
        this.context = context;
    }

    @NonNull
    @Override
    public seelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.sell_item, parent, false);
        return new seelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull seelHolder holder, int position) {
        Sell_java sell_java = sellList.get(position);
        holder.setdata(sell_java);
    }

    @Override
    public int getItemCount() {
        return sellList.size();
    }




    class seelHolder extends RecyclerView.ViewHolder {
        TextView q1, q2, q3, q4, q5;
        ImageView image;

        public seelHolder(@NonNull View itemView) {
            super(itemView);
            q1 = (TextView)itemView.findViewById(R.id.itemsellList1);
            q2 = (TextView)itemView.findViewById(R.id.itemsellList2);
            q3 = (TextView)itemView.findViewById(R.id.itemsellList3);
            q4 = (TextView)itemView.findViewById(R.id.itemsellList4);
            q5 = (TextView)itemView.findViewById(R.id.itemsellList5);
            System.out.println(q1.getText().toString());
            image = (ImageView) itemView.findViewById(R.id.itemimageViewSellResm);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClıck(sellList.get(position));
                }
            });
        }
     //   Bitmap image=image.getDrawingCache();
        //vv =findViewById(R.id.mm);
//        Bitmap d=vv.getDrawingCache();
        //      DB =new DBHelper(this);
        // d = DB.VeriListelephoto(d);
        //vv.setImageBitmap(d);
        public void setdata(Sell_java sell_java) {
            this.q1.setText(sell_java.getAdd());
            this.q2.setText(sell_java.getAdress());
            this.q3.setText(sell_java.getEmaill());
            this.q4.setText(sell_java.getPhonee());
            this.q5.setText(sell_java.getNotee());
            this.image.setImageBitmap(sell_java.getSellResim());
        }
    }
    public interface OnItemClickListener {
        void onItemClıck(Sell_java sell_java);
    }
    public void setOnItemClıckLıstener(OnItemClickListener listener) {
        this.listener = listener;

    }
    }


