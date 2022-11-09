package com.example.esciencenewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esciencenewsapp.Models.Headlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private Context context;
    private List<Headlines> headlinesList;
    private SelectedListener selectedListener;

    public NewsAdapter(Context context, List<Headlines> headlinesList, SelectedListener selectedListener) {
        this.context = context;
        this.headlinesList = headlinesList;
        this.selectedListener = selectedListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.items_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.title.setText(headlinesList.get(position).getTitle());
        holder.source.setText(headlinesList.get(position).getSource().getName());

        //check if image available
        if(headlinesList.get(position).getUrlToImage() != null){
            Picasso.get().load(headlinesList.get(position).getUrlToImage()).into(holder.image_holder);
        }

        holder.containerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedListener.OnNewsClicked(headlinesList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlinesList.size();
    }
}
