package com.example.pocketnews;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

        TabLayout tabLayout;
        TabItem thome , thealth,tentertainment,tscience,tsports,ttech;
        PagerAdapter pagerAdapter;
        Toolbar mtoolbar;
        String api = "a24438322fb84ec5832cabfc561611b5";
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mtoolbar = findViewById(R.id.toolbar);
            setSupportActionBar(mtoolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            thome = findViewById(R.id.home);
            tentertainment = findViewById(R.id.entertainment);
            thealth = findViewById(R.id.health);
            tsports = findViewById(R.id.sports);
            tscience = findViewById(R.id.science);
            ttech = findViewById(R.id.technology);

            ViewPager viewPager = findViewById(R.id.fragmentcontainer);
            tabLayout = findViewById(R.id.include);

            pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);
            viewPager.setAdapter(pagerAdapter);

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                    if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2 || tab.getPosition()==3 || tab.getPosition()==4 || tab.getPosition()==5)
                        pagerAdapter.notifyDataSetChanged();
                    Log.d("main activity","done");
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

           // viewPager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener) new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }

}