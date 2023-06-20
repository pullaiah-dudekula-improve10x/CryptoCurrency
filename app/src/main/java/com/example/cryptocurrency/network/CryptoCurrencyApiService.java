package com.example.cryptocurrency.network;

import com.example.cryptocurrency.modelclass.CryptoCurrency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoCurrencyApiService {

    @GET("v1/coins")
    Call<List<CryptoCurrency>> getCryptoCurrencyItems();
}
