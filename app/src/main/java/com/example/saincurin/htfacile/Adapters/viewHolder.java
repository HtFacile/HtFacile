package com.example.saincurin.htfacile.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saincurin.htfacile.R;
import com.squareup.picasso.Picasso;

public class viewHolder extends RecyclerView.ViewHolder {

    View mView;

    public viewHolder(View itemView) {
        super(itemView);

        mView = itemView;
    }

    //Set value to the recycleview row in the product tab
    public void setData(Context ctx, String title, String description, String image, String price) {
        //Initialise the views
        TextView mTitleTv = mView.findViewById(R.id.rvTitleTv);
        TextView mDesc = mView.findViewById(R.id.rDescriptionTv);
        ImageView mImageView = mView.findViewById(R.id.rImageView);
        TextView mPrice = mView.findViewById(R.id.rPrice);

        //Set the data to the views
        mTitleTv.setText(title);
        mDesc.setText(description);
        mPrice.setText(price);
        Picasso.with(ctx).load(image).into(mImageView);


    }
}
