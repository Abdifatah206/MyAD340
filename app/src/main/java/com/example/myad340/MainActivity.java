package com.example.myad340;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static android.view.View.*;



public class MainActivity extends AppCompatActivity {



    Button btn;
    Button east;
    Button west;
    Button south;
    Button north;
    Button roadbtn;
    Button mapbtn;
        EditText edit;
    //Menu menu;
    public void init() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcome = new Intent(MainActivity.this, screen2.class);

                startActivity(welcome);
            }

        });
    }
    public void east1() {
        east = (Button) findViewById(R.id.east);
        east.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent E = new Intent(MainActivity.this, East.class);

                startActivity(E);
            }

        });
    }
    public void road() {
        roadbtn = (Button) findViewById(R.id.camers);
        roadbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity.this, traffic_camera.class);

                startActivity(b);
            }

        });
    }
    /**** map  intent ***/
    public void mapss() {
        mapbtn = (Button) findViewById(R.id.loc);
        mapbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this, TrafficMap.class);

                startActivity(m);
            }

        });
    }





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        east1();
        road();
       mapss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon1:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


    /** Called when the user taps the Send button */




        //edit = (EditText) findViewById(R.id.txt);
       // String message = edit.getText().toString();
       // Toast.makeText(MainActivity.this,message, Toast.LENGTH_LONG).show();

        // Do something in response to button







/*
    public void east(View view) {

        Toast.makeText(MainActivity.this,"H E L L O  E A S T", Toast.LENGTH_LONG).show();

        // Do something in response to button
    }
    */
    public void south(View view) {

        Toast.makeText(MainActivity.this,"H E L L O  S O U T H", Toast.LENGTH_LONG).show();

        // Do something in response to button
    }
    /*
    public void west(View view) {

        Toast.makeText(MainActivity.this,"H E L L O  W E S T ", Toast.LENGTH_LONG).show();

        // Do something in response to button
    }
    */
    public void north(View view) {

        Toast.makeText(MainActivity.this,"H E L L O  N O R T H", Toast.LENGTH_LONG).show();

        // Do something in response to button
    }
}