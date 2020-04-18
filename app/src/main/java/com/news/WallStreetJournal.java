package com.news;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class WallStreetJournal extends Fragment {

    private ArrayList<Data.Articles> newsList;
    private NewsAdapter newsAdapter;

    public WallStreetJournal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wall_street_journal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.show_wsj_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getRsult();

        newsList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsAdapter);

    }

    private void getRsult(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsApi.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsApi service = retrofit.create(NewsApi.class);

        Call<Data> response = service.getRsult("wsj.com","2d832b6251834cd29b6581f8ce28d0e3");

        response.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                List<Data.Articles> list = response.body().getArticles();
                newsList.addAll(list);
                newsAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.e("TopHeadlines", "onFailure: "+t);
                Toast.makeText(getActivity(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
