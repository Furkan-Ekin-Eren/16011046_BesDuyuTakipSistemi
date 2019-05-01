package com.example.asdf;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Ayrinti extends AppCompatActivity {
    TextView aAD, aSoy, aTel, aMail, aTc;
    ImageView aFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayrinti);
        Intent gel = getIntent();
        customer cus = (customer) gel.getSerializableExtra("aa");
        aAD = findViewById(R.id.cAyirAd);
        aSoy = findViewById(R.id.cAyirSoyAd);
        aTel = findViewById(R.id.cAyirTel);
        aMail = findViewById(R.id.cAyirMail);
        aTc = findViewById(R.id.cAyirTc);
        aFoto = findViewById(R.id.cAyirFoto);

        aAD.setText(cus.getAd());
        aSoy.setText(cus.getSoyAd());
        aTel.setText(cus.getTelNo());
        aMail.setText(cus.geteMail());
        aTc.setText(cus.getTc());
        Uri myUri = Uri.parse(cus.getCusUri());
        aFoto.setImageURI(myUri);

    }
}
