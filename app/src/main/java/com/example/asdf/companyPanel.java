package com.example.asdf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class companyPanel extends AppCompatActivity {
    Button cusAdd, cusShow, medAdd, medShow;
    private company sirket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_panel);

        cusAdd = findViewById(R.id.customerAddButton);
        cusShow = findViewById(R.id.customerShowButton);
        medAdd = findViewById(R.id.mediaAddButton);
        medShow = findViewById(R.id.mediaShowButton);

        Intent gel = getIntent();
        sirket = (company) gel.getSerializableExtra("ss");

        cusAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerAdd();
            }
        });

        cusShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerShow();
            }
        });

        medAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaAdd();
            }
        });

        medShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaShow();
            }
        });

    }

    private void customerAdd() {
        Intent istek = new Intent(getApplicationContext(), customerAddPanel.class);
        istek.putExtra("ss",sirket);
        startActivity(istek);
    }

    private void customerShow() {
        Intent istek = new Intent(getApplicationContext(), ekran3.class);
        istek.putExtra("ss",sirket);
        startActivity(istek);
    }

    private void mediaAdd() {
        Intent istek = new Intent(getApplicationContext(), mediaAddPanel.class);
        istek.putExtra("ss",sirket);
        startActivity(istek);
    }

    private void mediaShow() {
        Intent istek = new Intent(getApplicationContext(), mediaShowPanel.class);
        istek.putExtra("ss",sirket);
        startActivity(istek);

    }


}
