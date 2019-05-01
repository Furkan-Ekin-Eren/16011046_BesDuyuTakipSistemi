package com.example.asdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ekran3 extends AppCompatActivity {
    RecyclerView recyclerView;
    private company sirket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran3);

        Intent gel = getIntent();
        sirket = (company) gel.getSerializableExtra("ss");

        recyclerView = findViewById(R.id.recyclerview);
        ArrayList<customer> listem=sirket.getCustomers();
        Adapter adapter = new Adapter(this,listem);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    }


}
