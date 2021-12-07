package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class First extends Fragment {
    FloatingActionButton Add;
    FirebaseFirestore db;
    String name[]={"home","add","calender"};
    int image[]={R.drawable.baseline_home_20,R.drawable.ic_baseline_add_24,R.drawable.baseline_calendar_month_20};
    RecyclerView recyclerview;
    ArrayList<RVAdapter.ItemModel> arrayList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        db=FirebaseFirestore.getInstance();
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_first, container, false);
        Add= rootView.findViewById(R.id.add);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerview = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(layoutManager);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "HEYY", Toast.LENGTH_SHORT).show();
              // startActivity(new Intent(getActivity(),Second.class));
                Intent intent = new Intent(getActivity(),First_Question.class);
                ((MainActivity) getActivity()).startActivity(intent);
            }
        });
        arrayList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            RVAdapter.ItemModel itemModel = new RVAdapter.ItemModel();
            itemModel.setName(name[i]);
            itemModel.setImage(image[i]);
            itemModel.setType("StudyPlan");

            //add in array list
            arrayList.add(itemModel);
        }

        RVAdapter adapter = new RVAdapter(arrayList);
        recyclerview.setAdapter(adapter);
        return rootView;
    }










        }




