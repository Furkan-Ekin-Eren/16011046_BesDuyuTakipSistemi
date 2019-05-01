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

public class mediaAdap extends RecyclerView.Adapter<mediaAdap.mediaHolder> {
    ArrayList<media> mDataList;
    LayoutInflater inflater;
    Context mContext;

    public mediaAdap(ArrayList<media> mDataList, Context mContext) {
        this.mDataList = mDataList;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContext = mContext;
    }

    @NonNull
    @Override


    public mediaAdap.mediaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.list_item, viewGroup, false);
        mediaHolder Holder = new mediaHolder(v);
        return Holder;
    }

    @Override
    public void onBindViewHolder(@NonNull mediaAdap.mediaHolder mediaHolder, int i) {
        final media tiklaMed = mDataList.get(i);
        mediaHolder.setData(tiklaMed, i);
        mediaHolder.mMedName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iistek = new Intent(mContext, mediaAyrinti.class);
                iistek.putExtra("bbb", tiklaMed);
                mContext.startActivity(iistek);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void deleteItem(int i) {
        mDataList.remove(i);
        notifyItemRemoved(i);
    }

    public void addItem(int i, media kopya) {
        mDataList.add(i, kopya);
        notifyItemInserted(i);
    }


    class mediaHolder extends RecyclerView.ViewHolder {
        TextView mMedName, mMedId;
        ImageView mMedResmi, mSilResmi, mKopyalaResmi;
        int position = 0;
        media mediaKopya;

        public mediaHolder(@NonNull View itemView) {
            super(itemView);
            mMedName = itemView.findViewById(R.id.ders_Adı);
            mMedId = itemView.findViewById(R.id.ders_notu);
            mMedResmi = itemView.findViewById(R.id.ders_resmi);
            mSilResmi = itemView.findViewById(R.id.sil_image);
            mKopyalaResmi = itemView.findViewById(R.id.kopyala_image);


            mSilResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(position);
                }
            });

            mKopyalaResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItem(position, mediaKopya);
                }
            });

        }

        public void setData(media tiklanılanDers, int i) {
            this.mMedName.setText(tiklanılanDers.getAd());
            this.mMedId.setText(tiklanılanDers.getMediaId());
            //  if (tiklanılanDers.getCusImage()==R.drawable.no_image){
            Uri myUri = Uri.parse(tiklanılanDers.getMedUri());
            this.mMedResmi.setImageURI(myUri);
            //  }else{ this.mCusResmi.setImageResource(tiklanılanDers.getCusImage()); }

            this.position = i;
            this.mediaKopya = tiklanılanDers;
        }

    }
}
