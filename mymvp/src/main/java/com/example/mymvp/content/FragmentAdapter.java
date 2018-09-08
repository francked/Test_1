package com.example.mymvp.content;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.mymvp.content.fragment.CategroyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 18-8-30.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> titles;
    private Fragment mCurFragment;

    public FragmentAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        fragmentList = new ArrayList<>();
        this.titles = titles;

        for (String s : titles){
            Fragment fragment = new CategroyFragment().setArguments(s);
            fragmentList.add(fragment);
        }

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mCurFragment = (Fragment) object;
    }

    public Fragment getmCurFragment(){
        return mCurFragment;
    }
}
