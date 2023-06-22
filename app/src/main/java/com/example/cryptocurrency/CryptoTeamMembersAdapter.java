package com.example.cryptocurrency;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptocurrency.databinding.TagsItemBinding;
import com.example.cryptocurrency.databinding.TeamsItemBinding;
import com.example.cryptocurrency.modelclass.Team;

import java.util.List;

public class CryptoTeamMembersAdapter extends RecyclerView.Adapter<CryptoTeamMembersViewHolder> {

    private List<Team> team;

    public void setUpTeamDetails(List<Team> team) {
        this.team = team;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CryptoTeamMembersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TeamsItemBinding binding = TeamsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CryptoTeamMembersViewHolder viewHolder = new CryptoTeamMembersViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoTeamMembersViewHolder holder, int position) {
        Team teamList = team.get(position);
        holder.binding.setTeam(teamList);
    }

    @Override
    public int getItemCount() {
        return team.size();
    }
}
