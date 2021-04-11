package com.example.mangalist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName ;
    private ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tv_name);
        ivPhoto = findViewById(R.id.iv_photo);

        tvName.setText(getIntent().getStringExtra("name"));

        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("photo")).into(ivPhoto);

    }
}