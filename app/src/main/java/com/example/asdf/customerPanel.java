package com.example.asdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class customerPanel extends AppCompatActivity {
    Button reportAdd,reportShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_panel);
        reportAdd=findViewById(R.id.reportAddButton);
        reportShow=findViewById(R.id.reportShowButton);
    }
}
