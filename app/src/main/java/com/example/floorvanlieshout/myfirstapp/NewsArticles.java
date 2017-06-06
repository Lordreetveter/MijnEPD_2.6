package com.example.floorvanlieshout.myfirstapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewsArticles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_articles);

        if(findViewById(R.id.fragment_container)!= null) {
            if (savedInstanceState != null) {
                return;
            }
            FirstFragment fragment = new FirstFragment();
            fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    public void veranderFragment(View view) {
        SecondFragment fragment2 = new SecondFragment();
        fragment2.setArguments(getIntent().getExtras());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment2);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
