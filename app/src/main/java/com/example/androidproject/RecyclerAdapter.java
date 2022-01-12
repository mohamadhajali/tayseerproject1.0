package com.example.androidproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.bumptech.glide.Glide;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private Context context;
    private List<Room> roomList;
//    private int[] imageIds;
//    private String[] description;


    public RecyclerAdapter(Context context, List<Room> roomList) {
        this.context = context;
        this.roomList = roomList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //card_captioned_image
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.customer_card, null);


        return new ViewHolder((CardView) view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Room room = roomList.get(position);

        Glide.with(context).load(room.getImage()).into(holder.imageView);

        holder.textViewId.setText(room.getId());
        holder.textViewCapacity.setText(room.getCapacity());
        holder.textViewPriceByDay.setText(String.valueOf(room.getPriceByDay()));


/*
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);

        imageView.setImageDrawable(dr);

        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(description[position]);

 */
//        cardView.setOnClickListener( new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                //
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewId, textViewCapacity, textViewPriceByDay;
//        private CardView cardView;

        public ViewHolder(CardView cardView){
            super(cardView);
//            this.cardView = cardView;

            imageView = itemView.findViewById(R.id.roomImage);
            textViewId = itemView.findViewById(R.id.roomId);
            textViewCapacity = itemView.findViewById(R.id.roomCapacity);
            textViewPriceByDay = itemView.findViewById(R.id.roomPriceByDay);

        }

    }
}
