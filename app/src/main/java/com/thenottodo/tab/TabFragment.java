package com.thenottodo.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Subramanyam on 1/5/2018.
 */

public class TabFragment extends Fragment implements TabLayout.OnTabSelectedListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.tabfragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getView()!=null){
            tabLayout=getView().findViewById(R.id.tab_layout);
            viewPager=getView().findViewById(R.id.view_Pager);


            tabLayout.addTab(tabLayout.newTab().setText("Menu"));
            tabLayout.addTab(tabLayout.newTab().setText("List"));
            tabLayout.addTab(tabLayout.newTab().setText("POP"));

            PagerAdapterTab adapter=new PagerAdapterTab(getFragmentManager(),tabLayout);
            viewPager.setAdapter(adapter);
            tabLayout.addOnTabSelectedListener(this);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        }


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private class PagerAdapterTab extends FragmentStatePagerAdapter{
        TabLayout tabLayout;
        public PagerAdapterTab(FragmentManager supportFragmentManager, TabLayout tabLayout) {
            super(supportFragmentManager);
            this.tabLayout=tabLayout;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            Log.e("p",""+position);
            if (position==0){
                fragment= new BlankFragment1();
            }
            if (position==1){
                fragment= new BlankFragment2();
            }
            if (position==2){
                fragment= new BlankFragment3();
            }
            return fragment;

        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
