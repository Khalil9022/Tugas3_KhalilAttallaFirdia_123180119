package com.example.mangalist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.ViewHolder> {

    public ArrayList<FootballModel> getFootballModels() {
        return footballModels;
    }

    public void setFootballModels(ArrayList<FootballModel> footballModels) {
        this.footballModels = footballModels;
    }

    private ArrayList<FootballModel> footballModels;

    public FootballAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_football, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Glide.with(context).load(getFootballModels().get(i).getLogoTeam()).into(holder.logo);
        holder.tvNama.setText(getFootballModels().get(i).getNamaTeam());

        holder.tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("photo", getFootballModels().get(i).getLogoTeam());
                intent.putExtra("name", getFootballModels().get(i).getNamaTeam());
                context.startActivities(new Intent[]{intent});
            }
        });

    }

    @Override
    public int getItemCount() {
        return footballModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView logo;
        private TextView tvNama,tvDetail ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.iv1);
            tvNama = itemView.findViewById(R.id.tvnama);
            tvDetail = itemView.findViewById(R.id.tv_detail);
        }
    }
}