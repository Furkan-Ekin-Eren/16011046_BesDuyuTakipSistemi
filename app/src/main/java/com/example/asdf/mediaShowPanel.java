package com.example.asdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class mediaShowPanel extends AppCompatActivity {
    RecyclerView recyclerView2;
    private company sirket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_show_panel);

        Intent gel = getIntent();
        sirket = (company) gel.getSerializableExtra("ss");

        recyclerView2 = findViewById(R.id.recyclerview2);

        mediaAdap adapter = new mediaAdap(sirket.getMedias(),this);
        recyclerView2.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager);
    }
}
