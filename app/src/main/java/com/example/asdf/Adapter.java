package com.example.asdf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    ArrayList<customer> mDataList;
    LayoutInflater inflater;
    Context mContext;
    public Adapter(Context context,ArrayList<customer> data){
        this.mContext =context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mDataList=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=inflater.inflate(R.layout.list_item,viewGroup,false);
        MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final customer tiklanilanCustomer=mDataList.get(i);
        myViewHolder.setData(tiklanilanCustomer,i);
        myViewHolder.mCusName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent istek = new Intent(mContext,Ayrinti.class);
            istek.putExtra("aa",tiklanilanCustomer);
            mContext.startActivity(istek);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void deleteItem(int i){
        mDataList.remove(i);
        notifyItemRemoved(i);
    }

    public void addItem(int i,customer kopya){
       mDataList.add(i,kopya);
       notifyItemInserted(i);
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mCusName, mCusTc;
        ImageView mCusResmi,mSilResmi,mKopyalaResmi;
        int position=0;
        customer dersKopya;

        public MyViewHolder(View itemView){
            super(itemView);
            mCusName =itemView.findViewById(R.id.ders_Adı);
            mCusTc =itemView.findViewById(R.id.ders_notu);
            mCusResmi =itemView.findViewById(R.id.ders_resmi);
            mSilResmi=itemView.findViewById(R.id.sil_image);
            mKopyalaResmi=itemView.findViewById(R.id.kopyala_image);

            mSilResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                deleteItem(position);
                }
            });

            mKopyalaResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                addItem(position,dersKopya);
                }
            });


        }

        public void setData(customer tiklanılanDers, int i) {
            this.mCusName.setText(tiklanılanDers.getAd());
            this.mCusTc.setText(tiklanılanDers.getTc());
          //  if (tiklanılanDers.getCusImage()==R.drawable.no_image){
                Uri myUri = Uri.parse(tiklanılanDers.getCusUri());
                this.mCusResmi.setImageURI(myUri);
          //  }else{ this.mCusResmi.setImageResource(tiklanılanDers.getCusImage()); }

            this.position=i;
            this.dersKopya=tiklanılanDers;
        }
    }

}
