package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class addcart extends AppCompatActivity {
    TextView title, dec, price, inc, qty, total;
    ImageView img;
    Button now1;
    int i = 1;
    Activity z = this;

    int singl_price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcart);
        getSupportActionBar().hide();

        Intent intent1 = getIntent();
        String str_title = intent1.getStringExtra("title");
        String str_price = String.valueOf(intent1.getIntExtra("price", 0));
        int int_img = intent1.getIntExtra("vimg", 0);


        title = findViewById(R.id.tit1);
        img = findViewById(R.id.inimg);
        now1 = findViewById(R.id.now);
        dec = findViewById(R.id.decrease);
        inc = findViewById(R.id.increase);
        qty = findViewById(R.id.qt1);
        price = findViewById(R.id.det_prc);
        total = findViewById(R.id.tot1);


        total.setText(str_price);
        title.setText(str_title);
        price.setText(str_price);
        img.setImageResource(int_img);


        singl_price = Integer.parseInt(price.getText().toString());


        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                i++;
                qty.setText("" + i);
                total.setText(String.valueOf(i * singl_price));


            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i > 0) {

                    i--;
                    qty.setText("" + i);
                    total.setText(String.valueOf(i * singl_price));
                }
            }
        });
        now1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(i == 0)) {
                    Toast.makeText(addcart.this, "order successfully", Toast.LENGTH_SHORT).show();
                    z.finish();
                } else {
                    Toast.makeText(addcart.this, "select qty please", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
