package com.devgd.notificationlistenerservicedemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
    }


    public void start(View view) {
        Intent start=new Intent(MainActivity.this,Notificationservice.class);
        //if you want to pass any data to service class
        //you can pass it through this intent
        startService(start);
    }

    public void stop(View view) {
        Intent stop=new Intent(MainActivity.this,Notificationservice.class);
        stopService(stop);
    }

}