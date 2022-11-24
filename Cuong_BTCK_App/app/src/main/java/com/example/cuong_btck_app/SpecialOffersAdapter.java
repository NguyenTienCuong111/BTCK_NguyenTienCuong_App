package com.example.cuong_btck_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SpecialOffersAdapter extends RecyclerView.Adapter<SpecialOffersAdapter.SpecialOffersViewHolder> {

    private Context mContext;
    private List<SpecialOffers> mListSpecialOffers;

    public SpecialOffersAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<SpecialOffers> list){
        this.mListSpecialOffers = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SpecialOffersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcv_so,parent,false);
        return new SpecialOffersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialOffersViewHolder holder, int position) {
        SpecialOffers specialOffers = mListSpecialOffers.get(position);
        if(specialOffers ==  null){
            return;
        }
        holder.img_so.setImageResource(specialOffers.getResource_image());
        holder.tv_name_so.setText(specialOffers.getName_food_so());
        holder.tv_price_so.setText(specialOffers.getPrice_so());
    }

    @Override
    public int getItemCount() {
        if(mListSpecialOffers != null){
            return mListSpecialOffers.size();
        }

        return 0;
    }

    public class SpecialOffersViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_so;
        private TextView tv_name_so, tv_price_so;

        public SpecialOffersViewHolder(@NonNull View itemView) {
            super(itemView);

            img_so = itemView.findViewById(R.id.img_scv_so);
            tv_name_so = itemView.findViewById(R.id.tv_namefood_so);
            tv_price_so = itemView.findViewById(R.id.tv_price_so);
        }
    }
}
