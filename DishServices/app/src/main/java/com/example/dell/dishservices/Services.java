package com.example.dell.dishservices;

import android.os.Bundle;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class Services extends AppCompatActivity {
    FloatingActionButton call1,call2;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        call1 = (FloatingActionButton)findViewById(R.id.fab888);
        call2 = (FloatingActionButton)findViewById(R.id.fab999);
        toolbar=(Toolbar)findViewById(R.id.teku);
        initToolbar();
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int REQUEST_PHONE_CALL = 1;
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7875918691"));
                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    if(ContextCompat.checkSelfPermission(Services.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(Services.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                    }else{
                        startActivity(callIntent);
                    }
                }
            }
        });
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    final int REQUEST_PHONE_CALL = 1;
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:7875918691"));
                    if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                        if(ContextCompat.checkSelfPermission(Services.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(Services.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                        }else{
                            startActivity(callIntent1);
                        }
                    }
                }
            }
        });
    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home :{
                onBackPressed();
            }
        }
        return  super.onOptionsItemSelected(item);
    }

}
