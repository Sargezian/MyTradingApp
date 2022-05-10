package com.example.mytradingapp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Transferobjects.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> implements OnListItemClickListener {

    private ArrayList<News> news;
    OnListItemClickListener listener;
    Context context;


    public NewsAdapter(ArrayList<News> news, OnListItemClickListener listener,Context context) {
        this.news = news;
        this.listener = listener;
        this.context = context;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        NewsViewHolder holder = new NewsViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

      holder.title.setText(news.get(position).getTitle());
      holder.text.setText(news.get(position).getText());
      holder.symbol.setText(news.get(position).getSymbol());
      holder.publishedDate.setText(news.get(position).getPublishedDate());
      Glide.with(this.context).load(news.get(position).getImage()).into(holder.image);

    }



    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public void onClick(int position) {

    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {

         TextView symbol;
         TextView publishedDate;
         TextView title;
         TextView text;
         ImageView image;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getBindingAdapterPosition());

                }
            });
            symbol = itemView.findViewById(R.id.symbol);
            publishedDate = itemView.findViewById(R.id.publishedDate);
            title = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.text);
            image = itemView.findViewById(R.id.imageView);


        }

}


}
