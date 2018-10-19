package com.example.dell.dishservices.cart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dell.dishservices.R;

import java.util.List;

/**
 * Created by DELL on 27-03-2018.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {
    private Context mContext;
    private List<Album> albumList;




    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title,count;
        public ImageView thumbnail,overflow;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView)view.findViewById(R.id.title12);
            count=(TextView)view.findViewById(R.id.count);
            thumbnail=(ImageView)view.findViewById(R.id.thumbnail);
            overflow=(ImageView)view.findViewById(R.id.overflow);

        }
    }

    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView= LayoutInflater.from(parent.getContext())
               .inflate(R.layout.album_card,parent,false);
       return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Album album=albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNameOfSongs()+"sdfghjk");
        //loadind al cover using glide libray
        Glide.with(mContext).load(album.getThumbail()).into(holder.thumbnail);
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.overflow);
            }
        });




    }
    /*88888888888888888888 showing pop menu */

private void  showPopupMenu(View view){
    //inflate menu
    PopupMenu popup = new PopupMenu(mContext,view);
    MenuInflater inflater = popup.getMenuInflater();
    inflater.inflate(R.menu.home,popup.getMenu());
    popup.setOnMenuItemClickListener(new MyMenuItemListener());
    popup.show();
}
    //click listener for popup menu items
    class MyMenuItemListener implements PopupMenu.OnMenuItemClickListener {
        public MyMenuItemListener() {

        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.add_cart:
                    Toast.makeText(mContext, "Availale in Store", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.action_settings:
                    Toast.makeText(mContext, "Setting", Toast.LENGTH_LONG).show();
                    return true;
                default:
            }
            return false;
        }
    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
