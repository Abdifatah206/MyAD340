package com.example.myad340;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;


public class detail extends AppCompatActivity {
 //TextView titles;
 //TextView years;
 //TextView directors;

 //ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //titles = findViewById(R.id.d_title);

        //years = findViewById(R.id.d_year);
        //directors = findViewById(R.id.d_director);
        //image = findViewById(R.id.d_image);
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        TextView titles = (TextView)findViewById(R.id.d_title);
        titles.setText(title);

        //titles.setText(intent.getStringExtra("titles"));
        //years.setText(intent.getStringExtra("years"));
        //directors.setText(intent.getStringExtra("directors"));


    }
}
