package com.example.mangalist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<FootballModel> footballModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_team_list);
        rv.setHasFixedSize(true);
        footballModels.addAll(FootballData.getListData());
        showRecycleList();
    }

    private void showRecycleList() {
        rv.setLayoutManager(new LinearLayoutManager( this));
        FootballAdapter footballAdapter = new FootballAdapter(this);
        footballAdapter.setFootballModels(footballModels);
        rv.setAdapter(footballAdapter);
    }
}