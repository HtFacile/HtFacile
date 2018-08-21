package com.example.saincurin.htfacile.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saincurin.htfacile.Adapters.viewHolder;
import com.example.saincurin.htfacile.ModelData.DataModel;
import com.example.saincurin.htfacile.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;
    RecyclerView mRecycleView;
    View v;


    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_products, container, false);
        //RecycleView
        mRecycleView = v.findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);

        //send Query FirebaseDatabase
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference("shop");

        FirebaseRecyclerAdapter<DataModel, viewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<DataModel, viewHolder>(
                        DataModel.class,
                        R.layout.item_row,
                        viewHolder.class,
                        mReference
                ) {
                    @Override
                    protected void populateViewHolder(viewHolder viewHolder, DataModel model, int position) {
                        viewHolder.setData(getContext(), model.getTitle(), model.getDescription(), model.getImage(), model.getPrice());
                    }
                };

                //set the adapter to the recyclerview
                mRecycleView.setAdapter(firebaseRecyclerAdapter);


        return v;
    }

}
