package com.example.myad340;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button toast1;
    Button toast2;
    Button toast3;
    Button toast4;
    String mystring = "welcome North";
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** Called when the user taps the Send button */
    public void ondisplaymessage(View view) {
        edit = (EditText) findViewById(R.id.txt);
        String message = edit.getText().toString();
        Toast.makeText(MainActivity.this,message, Toast.LENGTH_LONG).show();

        // Do something in response to button
    }
    public void toast1(View view) {

        Toast.makeText(MainActivity.this,"H E L L O  E A S T", Toast.LENGTH_LONG).show();

        // Do something in response to button
    }
    public void toast2(View view) {

        Toast.makeText(MainActivity.this,"H E L L O  S O U T H", Toast.LENGTH_LONG).show();

        // Do something in response to button
    }
    public void toast3(View view) {

        Toast.makeText(MainActivity.this,"H E L L O  W E S T ", Toast.LENGTH_LONG).show();

        // Do something in response to button
    }
    public void toast4(View view) {

        Toast.makeText(MainActivity.this,"H E L L O  N O R T H", Toast.LENGTH_LONG).show();

        // Do something in response to button
    }
}