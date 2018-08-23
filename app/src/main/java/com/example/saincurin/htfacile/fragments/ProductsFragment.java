package com.example.saincurin.htfacile.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.saincurin.htfacile.Adapters.ProductsAdapter;
import com.example.saincurin.htfacile.ModelData.DataModel;
import com.example.saincurin.htfacile.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    private RecyclerView mRecycleView;
    private ProductsAdapter mProductsAdapter;

    private DatabaseReference mReference;
    private List<DataModel> mDataModel;

    View v;

    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_products, container, false);

        //RecycleView
        mRecycleView = v.findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);
        //set Layout as LinearLayout
        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        mDataModel = new ArrayList<>();


        //send Query FirebaseDatabase
       mReference = FirebaseDatabase.getInstance().getReference("uploads");

        Log.e("DEBUG", "The Reference :"+mReference);

        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    DataModel dataModel = postSnapshot.getValue(DataModel.class);
                    mDataModel.add(dataModel);
                }
//                Log.e("DEBUG","The data model "+ mDataModel.toString());
                mProductsAdapter = new ProductsAdapter(getContext(), mDataModel);
//                Log.e("DEBUG","The data model "+ mProductsAdapter);

                //set the adapter to the recyclerview
                mRecycleView.setAdapter(mProductsAdapter);
                mProductsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        return v;
    }

}
