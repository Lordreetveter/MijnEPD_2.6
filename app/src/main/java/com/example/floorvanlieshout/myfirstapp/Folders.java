package com.example.floorvanlieshout.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Folders extends AppCompatActivity {
    private boolean menuZichtbaar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.folders_layout);
        menuZichtbaar = false;
    }

    public void viewFiles(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void makeMenuVisible(View view) {
        if (!menuZichtbaar) {
            View nieuweMapButton = findViewById(R.id.buttonNieuweMap);
            nieuweMapButton.setVisibility(View.VISIBLE); //To set visible
            View plusButton = findViewById(R.id.floatingActionButton);
            plusButton.setRotation(45);
            menuZichtbaar = true;
        } else {
            View nieuweMapButton = findViewById(R.id.buttonNieuweMap);
            nieuweMapButton.setVisibility(View.INVISIBLE); //To set visible
            View plusButton = findViewById(R.id.floatingActionButton);
            plusButton.setRotation(0);
            menuZichtbaar = false;
        }
    }
}
