package com.example.saincurin.htfacile.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saincurin.htfacile.ModelData.DataModel;
import com.example.saincurin.htfacile.R;
import com.squareup.picasso.Picasso;

import java.util.List;


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsviewHolder> {
    private Context mcontext;
    // Store a member variable for the contacts
    private List<DataModel> mDataModel;

    public ProductsAdapter(Context context, List<DataModel> mDataModel) {
        mcontext = context;
        this.mDataModel = mDataModel;
    }


    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ProductsviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the custom Layout
        View dataView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        //return a new holder instance
        return new  ProductsviewHolder(dataView);


    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ProductsviewHolder holder, int position) {
        // Get the data model based on position
        DataModel dataModel = mDataModel.get(position);

        // Set item views based on your views and data model
        holder.txtName.setText(dataModel.getName());
//        holder.txtDescription.setText(dataModel.getDescription());
        holder.txtPrice.setText(dataModel.getPrice());
        Picasso.with(mcontext)
                .load(dataModel.getImage())
                .fit()
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mDataModel.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ProductsviewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
//        public TextView txtDescription;
        public TextView txtPrice;
        public TextView txtQuantity;
        public ImageView imageView;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ProductsviewHolder(View itemView) {

            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            txtName = itemView.findViewById(R.id.rvTitleTv);
//            txtDescription = itemView.findViewById(R.id.rDescriptionTv);
            txtPrice = itemView.findViewById(R.id.rPrice);
            imageView = itemView.findViewById(R.id.rImageView);

        }
    }


}
