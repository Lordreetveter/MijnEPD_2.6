package com.example.floorvanlieshout.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class bestandAanmaken extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestand_aanmaken);
        Intent intent = getIntent();
        Uri uriFoto = Uri.parse(intent.getStringExtra("PICTURE_URI"));
        ImageView fotoView = (ImageView)findViewById(R.id.fotoView);
        fotoView.setImageURI(uriFoto);
    }
}
