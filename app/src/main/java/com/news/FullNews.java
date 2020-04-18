package com.news;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FullNews extends AppCompatActivity {
    String nUrl;
    WebView loadUrlView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);

        Intent intent = getIntent();
        nUrl = intent.getStringExtra("url");
        loadUrlView = findViewById(R.id.loadUrl);
        loadUrlView.loadUrl(nUrl);
    }
}
