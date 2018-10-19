package com.example.dell.dishservices;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 25-03-2018.
 */

public class ViewzPageAdapter extends FragmentPagerAdapter {
    private  final List<Fragment> fragmentList=new ArrayList<>();
    private  final List<String> fragmentListTitles=new ArrayList<>();

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    public ViewzPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return fragmentListTitles.size();
    }
    public CharSequence getPageTitle(int position)
    {
        return fragmentListTitles.get(position);
    }
    public void AddFragment(Fragment fragment,String title)
    {
       fragmentList.add(fragment);
      fragmentListTitles.add(title);

    }
}
