package com.news;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {


    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                TopHeadlines topHeadlines = new TopHeadlines();
                return topHeadlines;

            case 1:
                Bitcoin bitcoin = new Bitcoin();
                return bitcoin;

            default:
                Apple apple = new Apple();
                return apple;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Top Headlines";

            case 1:
                return "Bitcoin";

            case 2:
                return "Apple";

            case 3:
                return "TechCrunch";

            default:
                return "Wall Street Journal";
        }
    }
}
