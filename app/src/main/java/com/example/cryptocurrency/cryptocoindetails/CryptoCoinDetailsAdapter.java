package com.example.cryptocurrency.cryptocoindetails;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.TagsItemBinding;
import com.example.cryptocurrency.modelclass.Tags;

import java.util.List;

public class CryptoCoinDetailsAdapter extends RecyclerView.Adapter<CryptoCoinDetailsViewHolder> {

    private List<Tags> tags;

    void setCoinDetails(List<Tags> tags) {
        this.tags = tags;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CryptoCoinDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TagsItemBinding binding = TagsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CryptoCoinDetailsViewHolder cryptoCoinDetailsViewHolder = new CryptoCoinDetailsViewHolder(binding);
        return cryptoCoinDetailsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoCoinDetailsViewHolder holder, int position) {
        Tags tagList = tags.get(position);
        holder.binding.setTag(tagList);
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }
}
