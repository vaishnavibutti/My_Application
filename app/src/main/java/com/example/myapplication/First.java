package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;


public class First extends Fragment {
    FloatingActionButton Add;
    FirebaseFirestore db;
    List<DocumentSnapshot> mylist;
    private static ArrayList<com.example.myapplication.Type> mArrayList  ;

    String name[]={"home","add","calender"};

    RecyclerView recyclerview;
    ArrayList<RVAdapter.ItemModel> arrayList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        arrayList = new ArrayList<>();
        mArrayList= new ArrayList<>();
        db=FirebaseFirestore.getInstance();

        db.collection("Exam").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                                             @Override
                                                             public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                                                 if(queryDocumentSnapshots.isEmpty()){
                                                                     Log.d(TAG,"onSucces:LISTEMPTY");
                                                                     return;
                                                                 }
                                                                 else{
                                                                     List<Type> types=queryDocumentSnapshots.toObjects(Type.class);

                                                                     mArrayList.addAll(types);
                                                                     Log.d(TAG,"onSuccess: "+mArrayList);

                                                                     System.out.println(mArrayList.get(0).getName());
                                                                     System.out.println(mArrayList.size());
                                                                     RVAdapter.ItemModel itemModel = new RVAdapter.ItemModel();
                                                                     itemModel.setName(mArrayList.get(0).getName());
                                                                     itemModel.setType(mArrayList.get(0).getDate());
                                                                     arrayList.add(itemModel);
                                                                     RVAdapter adapter = new RVAdapter(arrayList);
                                                                     recyclerview.setAdapter(adapter);

                                                                 }
                                                             }
                                                         }

        ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(),"ERROR GETTING DATA",Toast.LENGTH_LONG).show();
            }
        });
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_first, container, false);
        Add= rootView.findViewById(R.id.add);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerview = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(layoutManager);
        System.out.println(mArrayList.size());

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "HEYY", Toast.LENGTH_SHORT).show();
              // startActivity(new Intent(getActivity(),Second.class));
                Intent intent = new Intent(getActivity(),First_Question.class);
                ((MainActivity) getActivity()).startActivity(intent);
            }
        });

        System.out.println(mArrayList.size());
        for (int i = 0; i < 6; i++) {
            RVAdapter.ItemModel itemModel = new RVAdapter.ItemModel();
            itemModel.setName(name[i/2]);
            itemModel.setType("Exam");




            //add in array list
            arrayList.add(itemModel);
            System.out.println(arrayList.get(i).getName());
        }
        System.out.println("heyy"+mArrayList.size());

        System.out.println("hello");
        return rootView;

    }










        }




