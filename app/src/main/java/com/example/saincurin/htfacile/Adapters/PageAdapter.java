package com.example.saincurin.htfacile.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.saincurin.htfacile.fragments.ProductsFragment;
import com.example.saincurin.htfacile.fragments.SpecialFragment;
import com.example.saincurin.htfacile.fragments.StoreFragment;

public class PageAdapter extends FragmentPagerAdapter {

    int numOfTAbs;

    public PageAdapter(FragmentManager fm, int numOfTAbs) {
        super(fm);
        this.numOfTAbs = numOfTAbs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ProductsFragment();
            case 1:
                return new SpecialFragment();
            case 2:
                return new StoreFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTAbs;
    }
}
