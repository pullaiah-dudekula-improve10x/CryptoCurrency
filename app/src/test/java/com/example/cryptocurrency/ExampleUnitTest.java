package com.example.cryptocurrency;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cryptocurrency.modelclass.CoinDetails;
import com.example.cryptocurrency.modelclass.CryptoCurrency;
import com.example.cryptocurrency.network.CryptoCurrencyApi;
import com.example.cryptocurrency.network.CryptoCurrencyApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCryptoCurrencyItems() throws IOException {
        CryptoCurrencyApiService apiService = new CryptoCurrencyApi().createCryptoCurrencyApiService();
        Call<List<CryptoCurrency>> call = apiService.getCryptoCurrencyItems();
        List<CryptoCurrency> cryptoCurrencies = call.execute().body();
        assertNotNull(cryptoCurrencies);
        assertFalse(cryptoCurrencies.isEmpty());
        System.out.println(new Gson().toJson(cryptoCurrencies));
    }

    @Test
    public void getCoinDetails() throws IOException {
        CryptoCurrencyApiService apiService = new CryptoCurrencyApi().createCryptoCurrencyApiService();
        Call<CoinDetails> call = apiService.fetchCoinDetails("btc-bitcoin");
        CoinDetails coinDetails = call.execute().body();
        assertNotNull(coinDetails);
        System.out.println(new Gson().toJson(coinDetails));
    }
}