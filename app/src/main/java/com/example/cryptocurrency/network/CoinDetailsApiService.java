package com.example.cryptocurrency.network;

import com.example.cryptocurrency.modelclass.CoinDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinDetailsApiService {

    @GET("v1/coins/btc-bitcoin")
    Call<CoinDetails> fetchCoinDetails();
}
