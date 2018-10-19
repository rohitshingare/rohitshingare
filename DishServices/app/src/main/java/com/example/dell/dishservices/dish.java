package com.example.dell.dishservices;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class dish extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);
        setupUIviews();
        initToolbar();
        setupListView();
       /* final String[] values = new String[]{"dish","airtel","d2h","tatasky"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.activity_list_item,android.R.id.text1,values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent myintent = new Intent(Intent.ACTION_VIEW);
                    myintent.setData(Uri.parse("https://paytm.com/dth-recharge"));
                    startActivity(myintent);

                }
                if(position==1){
                    Intent myintent1 = new Intent(Intent.ACTION_VIEW);
                    myintent1.setData(Uri.parse("https://paytm.com/dth-recharge"));
                    startActivity(myintent1);

                }
                if(position==2){
                    Intent myintent2 = new Intent(Intent.ACTION_VIEW);
                    myintent2.setData(Uri.parse("https://paytm.com/dth-recharge"));
                    startActivity(myintent2);

                }
                if(position==4){
                    Intent myintent3 = new Intent(Intent.ACTION_VIEW);
                    myintent3.setData(Uri.parse("https://paytm.com/dth-recharge"));
                    startActivity(myintent3);

                }
            }
        });*/
    }
    private void setupUIviews() {
        toolbar=(Toolbar)findViewById(R.id.Toolbar);
        listView=(ListView)findViewById(R.id.list_view);

    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dishes");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void setupListView(){
        String[] title = getResources().getStringArray(R.array.Services);
        String[] description = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,title,description);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://paytm.com/dth-recharge/airtel-digital-tv"));
                        startActivity(intent);
                        break;

                    }
                    case 1:{
                        Intent intent1 = new Intent(Intent.ACTION_VIEW);
                        intent1.setData(Uri.parse("https://paytm.com/dth-recharge/dish-tv"));
                        startActivity(intent1);
                        break;

                    }
                    case 2:{
                        Intent intent2 = new Intent(Intent.ACTION_VIEW);
                        intent2.setData(Uri.parse("https://paytm.com/dth-recharge/videocon-d2h"));
                        startActivity(intent2);
                        break;

                    }
                    case 3:{
                        Intent intent3 = new Intent(Intent.ACTION_VIEW);
                        intent3.setData(Uri.parse("https://paytm.com/dth-recharge/tata-sky"));
                        startActivity(intent3);
                        break;

                    }
                }
            }
        });


    }
    public class SimpleAdapter extends BaseAdapter
    {
        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,description;
        private  String[] titleArray;
        private  String[] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context,String[] title,String[] description)
        {
            mContext = context;
            titleArray = title;
            descriptionArray = description;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.single_item,null);

            }
            title =(TextView)convertView.findViewById(R.id.tvMain);
            description =(TextView)convertView.findViewById(R.id.tvMain1);
            imageView=(ImageView)convertView.findViewById(R.id.ivLetter);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("airtel")){
                imageView.setImageResource(R.drawable.airtel);
            } else if (titleArray[position].equalsIgnoreCase("dish")) {
                imageView.setImageResource(R.drawable.dishtv);
            }else if (titleArray[position].equalsIgnoreCase("d2h")) {
                imageView.setImageResource(R.drawable.d2h);
            }else
            {
                imageView.setImageResource(R.drawable.tatasky);
            }

            return  convertView;
        }

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


