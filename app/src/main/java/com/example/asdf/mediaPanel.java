package com.example.asdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class mediaPanel extends AppCompatActivity {
    Button newsAdd,newsShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_panel);
        newsAdd=findViewById(R.id.newsAddButton);
        newsShow=findViewById(R.id.newsShowButton);
    }
}
