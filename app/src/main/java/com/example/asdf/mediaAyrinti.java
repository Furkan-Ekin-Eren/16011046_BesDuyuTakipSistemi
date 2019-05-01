package com.example.asdf;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class mediaAyrinti extends AppCompatActivity {
    TextView amAD, amType, amTel, amMail, amId;
    ImageView amFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_ayrinti);
        Intent gel = getIntent();
        media med = (media) gel.getSerializableExtra("bbb");
        amAD = findViewById(R.id.mAyirAd);
        amType = findViewById(R.id.mAyirType);
        amTel = findViewById(R.id.mAyirTel);
        amMail = findViewById(R.id.mAyirMail);
        amId = findViewById(R.id.mAyirId);
        amFoto = findViewById(R.id.mAyirFoto);

        amAD.setText(med.getAd());
        amType.setText(med.getType());
        amTel.setText(med.getTelNo());
        amMail.setText(med.geteMail());
        amId.setText(med.getMediaId());
        Uri myUri = Uri.parse(med.getMedUri());
        amFoto.setImageURI(myUri);
    }
}
