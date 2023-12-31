package com.example.cryptocurrency.cryptocurrency;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.CryptoCurrencyItemBinding;
import com.example.cryptocurrency.modelclass.CryptoCurrency;

import java.util.List;

public class CryptoCurrencyAdapter extends RecyclerView.Adapter<CryptoCurrencyViewHolder> {

    private List<CryptoCurrency> cryptoCurrency;

    private OnItemActionListener onItemActionListener;

    void setUpCryptoCurrency(List<CryptoCurrency> cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }
    @NonNull
    @Override
    public CryptoCurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CryptoCurrencyItemBinding binding = CryptoCurrencyItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CryptoCurrencyViewHolder viewHolder = new CryptoCurrencyViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoCurrencyViewHolder holder, int position) {
        CryptoCurrency cryptoCurrencyList = cryptoCurrency.get(position);
        holder.binding.setCryptoCurrency(cryptoCurrencyList);
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClick(cryptoCurrencyList.getId());
        });
    }

    @Override
    public int getItemCount() {
        return cryptoCurrency.size();
    }
}
