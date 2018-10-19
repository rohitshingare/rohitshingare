package com.example.dell.dishservices;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.dell.dishservices.Database.Database;
import com.example.dell.dishservices.model.Dish;
import com.example.dell.dishservices.model.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DishDetail extends AppCompatActivity {
    TextView food_name,food_price,food_description;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String foodId="";
    FirebaseDatabase database;
    DatabaseReference foods;

    Dish currentDish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Food");
        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        btnCart = (FloatingActionButton)findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        foodId,
                        currentDish.getName(),
                        numberButton.getNumber(),
                        currentDish.getPrice(),
                        currentDish.getDiscount()
                ));
                Toast.makeText(DishDetail.this,"Added To CArt",Toast.LENGTH_LONG).show();
            }
        });
         food_description = (TextView)findViewById(R.id.food_description);
        food_name = (TextView)findViewById(R.id.food_name);
        food_price= (TextView)findViewById(R.id.food_price);
        food_image = (ImageView) findViewById(R.id.img_food);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapseAppbar);

//get id from Intent
        if(getIntent() != null)
            foodId = getIntent().getStringExtra("FoodId");
        if(foodId != null && !foodId.isEmpty()){
            getDetailFood(foodId);
        }


    }

    private void getDetailFood(String foodId) {
        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentDish = dataSnapshot.getValue(Dish.class);

                Picasso.with(getBaseContext()).load(currentDish.getImage())
                        .into(food_image);
                collapsingToolbarLayout.setTitle(currentDish.getName());

                food_price.setText(currentDish.getPrice());
                food_name.setText(currentDish.getName());
                food_description.setText(currentDish.getDescription());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
