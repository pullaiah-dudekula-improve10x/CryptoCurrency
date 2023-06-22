package com.example.cryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cryptocurrency.databinding.ActivityCryptoCoinDetailsBinding;
import com.example.cryptocurrency.modelclass.CoinDetails;
import com.example.cryptocurrency.modelclass.Tags;
import com.example.cryptocurrency.network.CryptoCurrencyApi;
import com.example.cryptocurrency.network.CryptoCurrencyApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CryptoCoinDetailsActivity extends AppCompatActivity {

    private CoinDetails coinDetails;

    private String id;
    private ActivityCryptoCoinDetailsBinding binding;

    private List<Tags> tags = new ArrayList<>();

    private CryptoCoinDetailsAdapter cryptoCoinDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCryptoCoinDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(getIntent().hasExtra("id")) {
            id = getIntent().getStringExtra("id");
        }
        fetchCryptoCoinDetails();
        setUpAdapter();
        setUpRv();
    }

    private void setUpRv() {
        binding.coinDetailsRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.coinDetailsRv.setAdapter(cryptoCoinDetailsAdapter);
    }
    private void setUpAdapter() {
        cryptoCoinDetailsAdapter = new CryptoCoinDetailsAdapter();
        cryptoCoinDetailsAdapter.setCoinDetails(tags);
    }
    private void fetchCryptoCoinDetails() {
        CryptoCurrencyApi cryptCurrencyApi = new CryptoCurrencyApi();
        CryptoCurrencyApiService coinDetailsApiService = cryptCurrencyApi.createCryptoCurrencyApiService();
        Call<CoinDetails> call = coinDetailsApiService.fetchCoinDetails(id);
        call.enqueue(new Callback<CoinDetails>() {
            @Override
            public void onResponse(Call<CoinDetails> call, Response<CoinDetails> response) {
                Toast.makeText(CryptoCoinDetailsActivity.this, "Fetched Items Successfully", Toast.LENGTH_SHORT).show();
                coinDetails = response.body();
                cryptoCoinDetailsAdapter.setCoinDetails(coinDetails.getTags());
                binding.setCoinDetails(coinDetails);
            }

            @Override
            public void onFailure(Call<CoinDetails> call, Throwable t) {
                Toast.makeText(CryptoCoinDetailsActivity.this, "Failed To Load Items", Toast.LENGTH_SHORT).show();

            }
        });
    }
}