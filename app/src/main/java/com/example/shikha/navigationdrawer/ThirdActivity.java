package com.example.shikha.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private MyPageAdapter myPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);
        myPageAdapter=new MyPageAdapter(getSupportFragmentManager());
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        tablayout=(TabLayout)findViewById(R.id.tab_layout);
        viewpager=(ViewPager)findViewById(R.id.viewpager);
        tablayout.setTabsFromPagerAdapter(myPageAdapter);
        viewpager.setAdapter(myPageAdapter);
        tablayout.setupWithViewPager(viewpager);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        setSupportActionBar(toolbar);

    }
    public static class MyFragment extends Fragment{
        public static final java.lang.String Page_no="page_no";
        public MyFragment()
        {


        }
        public static MyFragment newInstance(int no)
        {
            MyFragment fragment=new MyFragment();
            Bundle arguments=new Bundle();
            arguments.putInt(Page_no, no);
                fragment.setArguments(arguments);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
            Bundle arguments=getArguments();
            int no=arguments.getInt(Page_no);
            TextView mytextview=new TextView(getActivity());
            mytextview.setText("fragment no : "+ no);
            mytextview.setGravity(Gravity.CENTER);
            return mytextview;
            //return super.onCreateView(inflater,container,savedInstanceState);
        }
    }

}

class MyPageAdapter extends FragmentStatePagerAdapter{
    public MyPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        ThirdActivity.MyFragment myfragment=new ThirdActivity.MyFragment();
        return myfragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position)
    {
        return "TAB" + position;
    }
}
