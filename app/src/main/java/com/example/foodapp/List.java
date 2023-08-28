package com.example.foodapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodapp.R;

import java.util.List;
import java.util.zip.Inflater;

class MyArrayAdapter extends ArrayAdapter<String>{
    private final String[] mTitle;
    private final int[] mImgId;
    private final Activity context;
    private final int[] mprc;

    public MyArrayAdapter(@NonNull Context context, String[] mTitle, int[] mImgId, int[] mprc) {
        super(context, R.layout.myimgls,mTitle);
        this.mTitle = mTitle;
        this.mImgId = mImgId;
        this.context = (Activity) context;
        this.mprc = mprc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View row = layoutInflater.inflate(R.layout.myimgls,null,true);

        TextView  T = row.findViewById(R.id.set_Title);
        ImageView img = row.findViewById(R.id.set_img);
        TextView pp =row.findViewById(R.id.pp1);
        Button bb=row.findViewById(R.id.ordernow);


        T.setText(mTitle[position]);
        img.setImageResource(mImgId[position]);
        pp.setText(""+String.format("%s", mprc[position]));


        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(context,addcart.class);
                intent1.putExtra("title",mTitle[position]);
                intent1.putExtra("vimg",mImgId[position]);
                intent1.putExtra("price",mprc[position]);
                context.startActivity(intent1);
            }
        });

        return row;

    }

}
