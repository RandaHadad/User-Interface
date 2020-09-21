package com.example.ui.adaptors;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewpageAdaptor extends FragmentPagerAdapter {

    private List<Fragment> mfragmentlist = new ArrayList<>();
    private List<String> mfragmenttitle = new ArrayList<>();


    public ViewpageAdaptor( FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mfragmenttitle.get(position);
    }

    public Fragment getItem(int position) {
        return mfragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentlist.size();
    }
    public void  addfragment(Fragment fragment, String title){
        mfragmentlist.add(fragment);
        mfragmenttitle.add(title);
    }
}
