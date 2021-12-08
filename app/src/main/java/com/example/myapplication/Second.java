package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class Second extends Fragment {
    FloatingActionButton Add;
    FirebaseFirestore db;
    List<DocumentSnapshot> mylist;
    public static ArrayList<First_Type> mArrayList  ;
    static RVAdapter adapter;

    String name[]={"home","add","calender"};

    static RecyclerView recyclerview;
    static ArrayList<RVAdapter.ItemModel> arrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        arrayList = new ArrayList<>();
        mArrayList= new ArrayList<>();
        db=FirebaseFirestore.getInstance();

        View rootview= inflater.inflate(R.layout.fragment_first, container, false);
        Add=rootview.findViewById(R.id.add);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "HEYY", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(getActivity(),Second.class));

                Intent intent = new Intent(getActivity(),First_Question.class);
                intent.putExtra("mode","assignment");
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });
        return rootview;
    }
}