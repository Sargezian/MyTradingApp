package com.example.mytradingapp.View.Market;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class MarketFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_market, container, false);

        addFragment(inflate);

        return inflate;


    }

    private void addFragment(View view){

       tabLayout = view.findViewById(R.id.tab);
       viewPager = view.findViewById(R.id.viewpager);
       ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
       adapter.addFragment(new UsaFragment(),"Usa");
       adapter.addFragment(new EuropeFragment(),"Europe");
       adapter.addFragment(new AsiaFragment(),"Asia");
       viewPager.setAdapter(adapter);
       tabLayout.setupWithViewPager(viewPager);

    }

}