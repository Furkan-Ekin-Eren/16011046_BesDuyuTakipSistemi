package com.example.asdf;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class testMest extends AppCompatActivity {
    TextView id1,id2,id3,id4,id5;
    ImageView im1;
    veriTabani ver2 = new veriTabani(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mest);
        id1=findViewById(R.id.id1);
        id2=findViewById(R.id.id2);
        id3=findViewById(R.id.id3);
        id4=findViewById(R.id.id4);
        id5=findViewById(R.id.id5);
        im1=findViewById(R.id.cAyirFotoTest);
        ArrayList<customer> listem=ver2.getAllCustomers();

        id1.setText(listem.get(3).getAd());
        id2.setText(listem.get(3).geteMail());
        id3.setText(listem.get(3).getTc());
        id4.setText(listem.get(3).getTelNo());
        id5.setText(listem.get(3).getSoyAd());
        //String ret = listem.get(3).getCusUri();
       // File newImageFile = new File(ret);
        //Picasso.with(this).load(Uri.fromFile(newImageFile)).into(im1);


        Uri myUri = Uri.parse(listem.get(0).getCusUri());
        im1.setImageURI(myUri);

    }
}
