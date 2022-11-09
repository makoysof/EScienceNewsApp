package com.example.esciencenewsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView title, source;
    ImageView image_holder;
    CardView containerCard;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        source = itemView.findViewById(R.id.source);
        image_holder = itemView.findViewById(R.id.image_holder);
        containerCard = itemView.findViewById(R.id.container_card);
    }


}
