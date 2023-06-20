package com.example.cryptocurrency;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.CryptoCurrencyItemBinding;

public class CryptoCurrencyViewHolder extends RecyclerView.ViewHolder {

    CryptoCurrencyItemBinding binding;

    public CryptoCurrencyViewHolder(CryptoCurrencyItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
