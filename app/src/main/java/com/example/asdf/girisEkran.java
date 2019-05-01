package com.example.asdf;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class girisEkran extends AppCompatActivity {
    //Uri ur;
   // private media med1 = new media(R.drawable.cnn,"CNN","1111","cnn@gmail.com","05345432376","Televizyon Kanalı",new ArrayList<news>());
    //private customer cus1= new customer("Ali","Koç","05386331762","alikoc@gmail.com","36697892314",ur.toString(),R.drawable.ali,new ArrayList<report>());
    company sirket = new company("Beş duyu",new ArrayList<customer>(),new ArrayList<media>());


    EditText kullanıcıAdı,sifre;
    String kul="sirket",kul1="medya",kul2="müsteri",sif="password";
    Button giris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekran);

        kullanıcıAdı=findViewById(R.id.userName);
        sifre=findViewById(R.id.password);
        giris=findViewById(R.id.logIn);
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giril(kullanıcıAdı.getText().toString(),sifre.getText().toString());
            }
        });
    }


    private void giril(String kulad,String sifree){

        if( kulad.equals(kul) && sifree.equals(sif)){
            Intent istek=new Intent(getApplicationContext(),companyPanel.class);
            istek.putExtra("ss",sirket);
            startActivity(istek);
        }
        else{
            if( kulad.equals(kul1) && sifree.equals(sif)){
                Intent istek=new Intent(getApplicationContext(),mediaPanel.class);
                istek.putExtra("ss",sirket);
                startActivity(istek);
            }
            else{
                if( kulad.equals(kul2) && sifree.equals(sif)){
                    Intent istek=new Intent(getApplicationContext(),customerPanel.class);
                    istek.putExtra("ss",sirket);
                    startActivity(istek);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Şifre veya Kullanıcı adı hatalı",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
