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

public class customerAddPanel extends AppCompatActivity {
    EditText ad,soyad,Emaill,Telno,kimlik;
    Button kaydet,temizle;
    ImageView foto;
    Uri imageUri;
    company sirket;
    private static final int PICK_IMAGE=100;
    veriTabani ver = new veriTabani(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add_panel);

        ad=findViewById(R.id.cusAdtext);
        soyad=findViewById(R.id.cusSoyAdText);
        Emaill=findViewById(R.id.cusEmailText);
        Telno=findViewById(R.id.cusTelefonText);
        kimlik=findViewById(R.id.cusKimlikText);
        kaydet=findViewById(R.id.CusKaydet);
        temizle=findViewById(R.id.CusTemizle);
        foto=findViewById(R.id.cusKullanıcıFoto);


        Intent gel = getIntent();
        sirket = (company) gel.getSerializableExtra("ss");

        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.setText("");
                soyad.setText("");
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

    public void customerKaydet(View v){

        String[] dizi={ad.getText().toString(),soyad.getText().toString(),Emaill.getText().toString(),Telno.getText().toString(),kimlik.getText().toString()};
        customer cus=new customer(ad.getText().toString(), soyad.getText().toString(), Telno.getText().toString(),
                Emaill.getText().toString(), kimlik.getText().toString(), imageUri.toString(), R.drawable.no_image, new ArrayList<report>());

        if(dizi[0].length()==0 || dizi[1].length()==0 || dizi[2].length()==0 || dizi[3].length()==0 || dizi[4].length()==0 ){
            Toast.makeText(getApplicationContext(),"Lütfen tüm alanları doldurunuz.",Toast.LENGTH_SHORT).show();
        }else if(dizi[4].length()!=11)
        {
            Toast.makeText(getApplicationContext(),"T.C 11 haneli olmalı",Toast.LENGTH_SHORT).show();
        }
        else{
            if(dizi[3].length()!=11){
                Toast.makeText(getApplicationContext(),"Telefon numarası 11 haneli olmalı",Toast.LENGTH_SHORT).show();
            }
            else {
                sirket.getCustomers().add(new customer(ad.getText().toString(), soyad.getText().toString(), Telno.getText().toString(),
                        Emaill.getText().toString(), kimlik.getText().toString(), imageUri.toString(), R.drawable.no_image, new ArrayList<report>()));
                Toast.makeText(getApplicationContext(), "Müşteri Başarıyla Kaydedildi", Toast.LENGTH_SHORT).show();

                Intent istek = new Intent(getApplicationContext(), companyPanel.class);
                istek.putExtra("ss", sirket);
                startActivity(istek);
            }
        }

    }
}
