package com.example.cryptocurrency;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.CryptoCurrencyItemBinding;
import com.example.cryptocurrency.databinding.TagsItemBinding;

public class CryptoCoinDetailsViewHolder extends RecyclerView.ViewHolder {

    TagsItemBinding binding;
    public CryptoCoinDetailsViewHolder(TagsItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
