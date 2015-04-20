package com.miage.urd8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override 
	 public boolean onOptionsItemSelected(MenuItem item) {
	      switch (item.getItemId()) {
	          case R.id.add_rdv:
	              Intent intent = new Intent(this, AddRDVActivity.class);
	              intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	              startActivity(intent);	              
	              return true;
	          case R.id.add_repas:
	              Intent intentRepas = new Intent(this, AddRepasActivity.class);
	              intentRepas.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	              startActivity(intentRepas);	              
	              return true;
	          case R.id.add_courses:
	              Intent intentCourses = new Intent(this, AddCourseActivity.class);
	              intentCourses.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	              startActivity(intentCourses);	              
	              return true;
	          default:
	              return super.onOptionsItemSelected(item);
	      }
	  }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

    	Context c;
    	
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
        	Fragment fragment = null;
        	if (i == 0) {
                fragment = new FragmentRepas(c);
            }
            if (i == 1) {
                fragment = new FragmentRDV(c);
            }
            if (i == 2) {
                fragment = new FragmentCourses(c);
            }
            return fragment; 
        }

        @Override
        public int getCount() {
            return 3;
        }
        

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return getString(R.string.title_section1).toUpperCase();
                case 1: return getString(R.string.title_section2).toUpperCase();
                case 2: return getString(R.string.title_section3).toUpperCase();
            }
            return null;
        }
    }
    

    public static class DummySectionFragment extends Fragment {
        public DummySectionFragment() {
        }

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            Bundle args = getArguments();
            textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
            return textView;
        }
    }
}
