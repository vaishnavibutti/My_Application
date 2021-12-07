package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.viewHolder> {
    private List<String> mItems;
    ArrayList<ItemModel> arrayList;
    //ImageButton button;
    public RVAdapter(ArrayList<ItemModel> mItems){
        this.arrayList=mItems;
    }
    @Override
    public  viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new viewHolder(view);
    }
    @Override
    public  void onBindViewHolder(viewHolder viewHolder, int position) {
        viewHolder.name.setText(arrayList.get(position).getName());
        viewHolder.image.setImageResource(arrayList.get(position).getImage());


        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(position);
               notifyDataSetChanged();

                Toast.makeText(v.getContext(), "delete", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        ImageButton button;

        public viewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
            button=(ImageButton) itemView.findViewById(R.id.button);


        }

    }

    public static class ItemModel {

        int image;
        String name;
        String type;

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }










}
