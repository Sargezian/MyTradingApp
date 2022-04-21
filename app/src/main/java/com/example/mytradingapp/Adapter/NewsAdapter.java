package com.example.mytradingapp.Adapter;

import android.util.Log;
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

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnListItemClickListener {

    private ArrayList<News> news;
    OnListItemClickListener listener;


    public NewsAdapter(ArrayList<News> news, OnListItemClickListener listener) {
        this.news = news;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new NewsViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.news_item,
                        parent,
                        false
                )
        );

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        News newss = (News) news.get(position);
        ((NewsAdapter.NewsViewHolder)holder).setNews(newss);

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public void onClick(int position) {

    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {

        private TextView symbol;
        private TextView publishedDate;
        private TextView title;
        private TextView text;
        private ImageView image;
   /*     private TextView url;*/


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

        public void setNews(News news){

            symbol.setText(news.getSymbol());
            publishedDate.setText(news.getPublishedDate());
            title.setText(news.getTitle());
            text.setText(news.getText());
          /*  url.setText(news.getUrl());*/

            Glide.with(image.getContext()).load(news.getImage()).into(image);



        }

}


}
