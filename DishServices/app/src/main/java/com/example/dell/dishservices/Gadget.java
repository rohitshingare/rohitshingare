package com.example.dell.dishservices;


        import android.content.Intent;
        import android.os.Bundle;

        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.DefaultItemAnimator;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.Toolbar;
        import android.util.TypedValue;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.Toast;

        import com.bumptech.glide.Glide;
        import com.example.dell.dishservices.Interface.ItemClickListener;
        import com.example.dell.dishservices.ViewHolder.DishViewHolder;
        import com.example.dell.dishservices.cart.Album;
        import com.example.dell.dishservices.cart.AlbumsAdapter;
        import com.example.dell.dishservices.model.Dish;
        import com.firebase.ui.database.FirebaseRecyclerAdapter;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;
        import java.util.List;

public class Gadget extends AppCompatActivity {
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference dishList;
    FirebaseRecyclerAdapter<Dish,DishViewHolder> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadget);
        //firebase
        database = FirebaseDatabase.getInstance();
        dishList = database.getReference("Food");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_dish);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //get intent

        loadMenu();

    }

    private void loadMenu() {
       adapter = new FirebaseRecyclerAdapter<Dish, DishViewHolder>(Dish.class,R.layout.dish_item,
                DishViewHolder.class,dishList) {
            @Override
            protected void populateViewHolder(DishViewHolder viewHolder, Dish model, int position) {
                viewHolder.dish_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.dish_image);
                final Dish clickItem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent dishDetail = new Intent(Gadget.this,DishDetail.class);
                        dishDetail.putExtra("FoodId",adapter.getRef(position).getKey());
                        startActivity(dishDetail);

                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);

    }




}
