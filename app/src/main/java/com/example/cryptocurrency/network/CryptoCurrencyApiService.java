package com.example.cryptocurrency.network;

import com.example.cryptocurrency.modelclass.CoinDetails;
import com.example.cryptocurrency.modelclass.CryptoCurrency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CryptoCurrencyApiService {

    @GET("coins")
    Call<List<CryptoCurrency>> getCryptoCurrencyItems();

    @GET("coins/{id}")
    Call<CoinDetails> fetchCoinDetails(@Path("id") String id);
}

