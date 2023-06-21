package com.example.cryptocurrency.cryptocurrency;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.cryptocurrency.databinding.ActivityCryptoCurrencyBinding;
import com.example.cryptocurrency.modelclass.CryptoCurrency;
import com.example.cryptocurrency.network.CryptoCurrencyApi;
import com.example.cryptocurrency.network.CryptoCurrencyApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CryptoCurrencyActivity extends AppCompatActivity {

    private ActivityCryptoCurrencyBinding binding;

    private List<CryptoCurrency> cryptoCurrency = new ArrayList<>();

    private CryptoCurrencyApiService cryptoCurrencyApiService;

    private CryptoCurrencyAdapter cryptoCurrencyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCryptoCurrencyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fetchCryptoCurrencyItems();
        setUpAdapter();
        setUpRv();
    }

    private void fetchCryptoCurrencyItems() {
        setUpApi();
        Call<List<CryptoCurrency>> call = cryptoCurrencyApiService.getCryptoCurrencyItems();
        call.enqueue(new Callback<List<CryptoCurrency>>() {
            @Override
            public void onResponse(Call<List<CryptoCurrency>> call, Response<List<CryptoCurrency>> response) {
                Toast.makeText(CryptoCurrencyActivity.this, "Fetched Items Successfully", Toast.LENGTH_SHORT).show();
                List<CryptoCurrency> cryptoCurrencies = response.body();
                cryptoCurrencyAdapter.setUpCryptoCurrency(cryptoCurrencies);
            }

            @Override
            public void onFailure(Call<List<CryptoCurrency>> call, Throwable t) {
                Toast.makeText(CryptoCurrencyActivity.this, "Failed To Load Items", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setUpRv() {
        binding.cryptocurrencyRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cryptocurrencyRv.setAdapter(cryptoCurrencyAdapter);
    }

    private void setUpAdapter() {
        cryptoCurrencyAdapter = new CryptoCurrencyAdapter();
        cryptoCurrencyAdapter.setUpCryptoCurrency(cryptoCurrency);
    }

    private void setUpApi() {
        CryptoCurrencyApi cryptoCurrencyApi = new CryptoCurrencyApi();
        cryptoCurrencyApiService = cryptoCurrencyApi.createCryptoCurrencyApiService();
    }
}