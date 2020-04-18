package com.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private ArrayList<Data.Articles> listItem;

    public NewsAdapter (ArrayList<Data.Articles> listItem){
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_news_list,parent,false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsHolder holder, int position) {
        Data.Articles currentItem = listItem.get(position);
        final String news_Img = currentItem.getUrlToImage();
        final String news_Title = currentItem.getTitle();
        final String news_Autthor = currentItem.getAuthor();
        final String news_Date = currentItem.getPublishedAt();
        final String news_Description = currentItem.getDescription();
        final String news_url = currentItem.getUrl();
        Picasso.with(holder.newsAuthor.getContext()).load(news_Img).into(holder.newsImg);
        holder.newsTitle.setText(news_Title);
        holder.newsAuthor.setText(news_Autthor);
        holder.newsDate.setText(news_Date);
        holder.newsDescription.setText(news_Description);

        holder.newsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context,FullNews.class);
                intent.putExtra("url",news_url);
                context.startActivity(intent);
            }
        });

        holder.newsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context,FullNews.class);
                intent.putExtra("url",news_url);
                context.startActivity(intent);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,news_url);
                sendIntent.setType("text/*");
                Intent shareIntent = Intent.createChooser(sendIntent, "SHARE");
                Context context = v.getContext();
                context.startActivity(shareIntent);
            }
        });

        holder.bookmarkIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                if(holder.bookmarkIcon.getTag()==null){
                    holder.bookmarkIcon.setTag("Bookmarked");
                    holder.bookmarkIcon.setBackgroundResource(R.drawable.bookmark_clicked);
                    Toast.makeText(context,R.string.news_saved,Toast.LENGTH_SHORT).show();
                }
                else {
                    holder.bookmarkIcon.setTag(null);
                    holder.bookmarkIcon.setBackgroundResource(R.drawable.bookmark);
                    Toast.makeText(context,R.string.news_unsaved,Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {
        ImageView newsImg;
        TextView newsTitle,newsAuthor,newsDate,newsDescription;
        Button share,bookmarkIcon;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);

            newsImg = itemView.findViewById(R.id.news_img);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsAuthor = itemView.findViewById(R.id.news_author);
            newsDate = itemView.findViewById(R.id.news_date);
            newsDescription = itemView.findViewById(R.id.news_description);
            share = itemView.findViewById(R.id.shareBtn);
            bookmarkIcon = itemView.findViewById(R.id.bookmarkIcon);
        }
    }
}
