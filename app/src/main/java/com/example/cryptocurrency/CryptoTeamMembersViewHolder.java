package com.example.cryptocurrency;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.TeamsItemBinding;

public class CryptoTeamMembersViewHolder extends RecyclerView.ViewHolder {

    TeamsItemBinding binding;
    public CryptoTeamMembersViewHolder(TeamsItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
