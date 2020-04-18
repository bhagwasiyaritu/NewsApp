package com.news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    String BaseUrl = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<Data> getData(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);

    @GET("everything")
    Call<Data> getData(@Query("q") String q, @Query("from") String from, @Query("sortBy") String sortBy , @Query("apiKey") String apiKey);

    @GET("everything")
    Call<Data> getData(@Query("q") String q, @Query("from") String from, @Query("to") String to, @Query("sortBy") String sortBy , @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<Data> getData(@Query("sources") String sources, @Query("apiKey") String apiKey);

    @GET("everything")
    Call<Data> getRsult(@Query("domains") String domains, @Query("apiKey") String apiKey);
}
