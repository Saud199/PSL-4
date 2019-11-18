package com.bloodbrothers.abdulahad.psl4;

/**
 * Created by ABC on 07-Jan-19.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class mypagerAdapter extends FragmentStatePagerAdapter {


    ArrayList<Fragment>  mFragments;

    public mypagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){

            case 0:
                return "Dubai International Cricket Stadium";
            case 1:
                return "Sharjah Cricket Stadium";
            case 2:
                return "Sheikh Zayed Cricket Stadium";
            case 3:
                return "Gaddafi Stadium";
            case 4:
                return "National Stadium";
            default:
                return "Unknown";

        }
    }
}