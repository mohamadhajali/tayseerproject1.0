package com.example.androidproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Room> roomList;
    onClickInterface onClickInterface;

//    private int[] imageIds;
//    private String[] description;


    public RecyclerAdapter(Context context, ArrayList<Room> roomList ,onClickInterface onClickInterface) {
       this.context = context;
        this.roomList = roomList;
        this.onClickInterface = onClickInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_card,
                parent,
                false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Room room = roomList.get(position);
        CardView cardView = holder.cardView;

       ImageView imageView =  cardView.findViewById(R.id.roomImage);

        Picasso.with(context).load(room.getImage()).into(imageView);


        TextView roomId = (TextView)cardView.findViewById(R.id.roomId);
        roomId.setText(String.valueOf(room.getId()));
        TextView roomCapacity = (TextView)cardView.findViewById(R.id.roomCapacity);
        roomCapacity.setText(String.valueOf(room.getCapacity()));
        TextView roomPriceByDay = (TextView)cardView.findViewById(R.id.roomPriceByDay);
        roomPriceByDay.setText(String.valueOf(room.getPriceByDay()));
        String Idroom = String.valueOf(roomId.getText());
        String roomCapacity1 = String.valueOf(roomCapacity.getText());
        String PriceperDay = String.valueOf(roomPriceByDay.getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         //       Intent intent = new Intent(RecyclerAdapter.this,"",CustomerLogin.class);

                onClickInterface.setClick(Idroom,roomCapacity1,PriceperDay);
            }
        });

       /* cardView.setOnClickListener(v -> {
          //  Toast.makeText(LoginReceptionist.this,result,Toast.LENGTH_SHORT).show();

            //   Intent intent = new Intent(RecyclerAdapter.this,CustomerLogin.class);
        });*/
    }
    /*
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Pizza pizza = items.get(position);
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Glide.with(context).load(pizza.getImage()).into(imageView);
        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(pizza.getName());
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
            }
        });
    }
     */







    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        ImageView img_android;
        public ViewHolder(CardView cardView){
            super(cardView);
            img_android =(ImageView)  cardView.findViewById(R.id.roomImage);
            this.cardView = cardView;
        }

    }


}
