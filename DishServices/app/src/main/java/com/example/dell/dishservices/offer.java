package com.example.dell.dishservices;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class offer extends AppCompatActivity {
private TabLayout tabLayout;
private AppBarLayout appBarLayout;
private ViewPager viewPager;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer2);
        tabLayout=(TabLayout) findViewById(R.id.tabs);
        appBarLayout=(AppBarLayout)findViewById(R.id.appppp);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        toolbar=(Toolbar)findViewById(R.id.Tool_bar);
        ViewzPageAdapter adapter=new ViewzPageAdapter(getSupportFragmentManager());
         adapter.AddFragment(new FragmentNotification(),"Notification");
        adapter.AddFragment(new FragmentOffer(),"Offer");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        initToolbar();
    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dish Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
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
