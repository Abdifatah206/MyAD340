package com.example.myad340;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;

import android.net.ConnectivityManager;

import android.net.NetworkInfo;

import android.os.Bundle;

import android.support.v4.app.FragmentActivity;

import android.util.TypedValue;

import android.view.Menu;

import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;


//import com.example.android.common.logger.Log;

//import com.example.android.common.logger.LogFragment;

//import com.example.android.common.logger.LogWrapper;

//import com.example.android.common.logger.MessageOnlyLogFilter;

//import com.example.android.common.logger.LogFragment;


public class traffic_camera extends AppCompatActivity {
String  jobj = "https://data.seattle.gov/resource/sxgt-3deg.json";
    public static final String TAG = "Basic network";
    public static boolean wifiConnected = false;
    public static boolean mobileConnected = false;
    ArrayList<HashMap<String, String>> cameralists;
    //private LogFragment mLogFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_camera);
        ListView listView = (ListView)findViewById(R.id.camera_list);
        cameralists = new ArrayList<>();



    }
}
