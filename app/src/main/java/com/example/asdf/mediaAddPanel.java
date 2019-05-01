package com.example.asdf;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class mediaAddPanel extends AppCompatActivity {
    EditText ad,Emaill,Telno,kimlik,type;
    Button kaydet,temizle;
    ImageView foto;
    Uri imageUri;
    company sirket;
    private static final int PICK_IMAGE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_add_panel);
        ad=findViewById(R.id.medAdtext);
        Emaill=findViewById(R.id.medEmailText);
        Telno=findViewById(R.id.medTelefonText);
        kimlik=findViewById(R.id.medİdText);
        kaydet=findViewById(R.id.medKaydet);
        temizle=findViewById(R.id.medTemizle);
        foto=findViewById(R.id.medKullanıcıFoto);
        type=findViewById(R.id.medTypeText);
        Intent gel = getIntent();
        sirket = (company) gel.getSerializableExtra("ss");

        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.setText("");
                Emaill.setText("");
                Telno.setText("");
                kimlik.setText("");
                foto.setImageResource(R.drawable.no_image);

            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resimSec();
            }
        });
    }


    private void resimSec(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            foto.setImageURI(imageUri);
        }
    }

    public void medyaKaydet(View v){

        String[] dizi={ad.getText().toString(),Emaill.getText().toString(),Telno.getText().toString(),kimlik.getText().toString()};

        if(dizi[0].length()==0 || dizi[1].length()==0 || dizi[2].length()==0 || dizi[3].length()==0  ){
            Toast.makeText(getApplicationContext(),"Lütfen tüm alanları doldurunuz.",Toast.LENGTH_SHORT).show();
        }else if(dizi[3].length()!=4)
        {
            Toast.makeText(getApplicationContext(),"Medya id 4 haneli olmalı",Toast.LENGTH_SHORT).show();
        }
        else{
            if(dizi[2].length()!=11){
                Toast.makeText(getApplicationContext(),"Telefon numarası 11 haneli olmalı",Toast.LENGTH_SHORT).show();
            }
            else {
                sirket.getMedias().add(new media(R.drawable.no_image, ad.getText().toString(), kimlik.getText().toString(), Emaill.getText().toString(), Telno.getText().toString(),
                        type.getText().toString(), imageUri.toString(), new ArrayList<news>()));
                Toast.makeText(getApplicationContext(), "Medya Başarıyla Kaydedildi", Toast.LENGTH_SHORT).show();

                Intent istek = new Intent(getApplicationContext(), companyPanel.class);
                istek.putExtra("ss", sirket);
                startActivity(istek);
            }
        }

    }
}
