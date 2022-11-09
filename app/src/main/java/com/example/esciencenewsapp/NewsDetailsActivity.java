package com.example.esciencenewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.esciencenewsapp.Models.Headlines;
import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {

    Headlines headlines;
    TextView detail_title, detail_author, detail_time, detail_text, detail_content;
    ImageView image_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        headlines = (Headlines) getIntent().getSerializableExtra("data");

        detail_title = findViewById(R.id.detail_title);
        detail_author = findViewById(R.id.detail_author);
        detail_time = findViewById(R.id.detail_time);
        detail_text = findViewById(R.id.detail_text);
        detail_content = findViewById(R.id.detail_content);
        image_news = findViewById(R.id.image_news);


        //setting the contents onClick
        detail_title.setText(headlines.getTitle());
        detail_author.setText(headlines.getAuthor());
        detail_time.setText(headlines.getPublishedAt());
        detail_text.setText(headlines.getDescription());
        detail_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(image_news);
    }
}