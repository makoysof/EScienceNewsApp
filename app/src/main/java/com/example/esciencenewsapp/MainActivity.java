package com.example.esciencenewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.esciencenewsapp.Models.ApiResponse;
import com.example.esciencenewsapp.Models.Headlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectedListener, View.OnClickListener{

    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    Button general, business, health, technology, sports, science, entertainment;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager requestManager = new RequestManager(this);

        requestManager.getNews(listener, "general", null);

        general = findViewById(R.id.general);
        business = findViewById(R.id.business);
        health = findViewById(R.id.health);
        technology = findViewById(R.id.technology);
        sports = findViewById(R.id.sports);
        science = findViewById(R.id.science);
        entertainment = findViewById(R.id.entertainment);
        searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                RequestManager requestManager = new RequestManager(MainActivity.this);
                requestManager.getNews(listener, "general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnFetchDataListener<ApiResponse> listener = new OnFetchDataListener<ApiResponse>() {
        @Override
        public void onFetchData(List<Headlines> list, String message) {
            if(list.isEmpty()){
                Toast.makeText(MainActivity.this, "No article found", Toast.LENGTH_SHORT).show();
            }
            else{
                showNews(list);
            }
        }

        @Override
        public void onErrorListener(String message) {
            Toast.makeText(MainActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<Headlines> list) {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        newsAdapter = new NewsAdapter(this, list, this);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void OnNewsClicked(Headlines headlines) {
        startActivity(new Intent(MainActivity.this, NewsDetailsActivity.class)
                .putExtra("data", headlines));

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category = button.getText().toString();
        RequestManager requestManager = new RequestManager(this);
        requestManager.getNews(listener, category, null);

    }
}