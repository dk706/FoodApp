package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public  class Home extends AppCompatActivity {
    ListView list;

    String[] Title = {" Veg Burger","Pizza","Maisur dosa","Manchurian","Fried Veg Momos","Hotdog","Noodles","Double Cheese Pizza"};
    int[] pr={400,500,550,200,250,300,500,500};
    int[] imgId = {R.drawable.burger,R.drawable.pizza,R.drawable.dosa,R.drawable.manchurian,R.drawable.friedvegmomos,R.drawable.hotdog,R.drawable.noodles,R.drawable.doublecheesepizza};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        list = findViewById(R.id.ListView);

        MyArrayAdapter adapter = new MyArrayAdapter(Home.this,Title,imgId,pr);
        list.setAdapter(adapter);

    }
}