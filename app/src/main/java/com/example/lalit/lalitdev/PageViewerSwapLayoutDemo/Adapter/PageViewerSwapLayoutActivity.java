package com.example.lalit.lalitdev.PageViewerSwapLayoutDemo.Adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lalit.lalitdev.PageViewerSwapLayoutDemo.Activity.ViewPagerAdapter;
import com.example.lalit.lalitdev.R;
import com.viewpagerindicator.TabPageIndicator;


/**
 * Created by Admin on 12/7/2017.
 */

public class PageViewerSwapLayoutActivity extends Fragment {

    /**
     * TabPagerIndicator
     *
     * Please refer to ViewPagerIndicator library
     */
    TabPageIndicator indicator;
    TabLayout tabLayout ;
    protected ViewPager pager;
    private Fragment parentFragment;

    private ViewPagerAdapter adapter;

  //  private ViewPagerAdapter adapter;


    public PageViewerSwapLayoutActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_page_viewer_swape_layout, container, false);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tpi_header);

        pager = (ViewPager) rootView.findViewById(R.id.vp_pages);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Note that we are passing childFragmentManager, not FragmentManager
        adapter = new ViewPagerAdapter(getResources(), getChildFragmentManager());

        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
      //  tabLayout.setViewPager(pager);
    }

    /**
     * Retrieve the currently visible Tab Fragment and propagate the onBackPressed callback
     *
     * @return true = if this fragment and/or one of its associates Fragment can handle the backPress
     */
  /*  public boolean onBackPressed() {
        // currently visible tab Fragment
        OnBackPressListener currentFragment = (OnBackPressListener) adapter.getRegisteredFragment(pager.getCurrentItem());

        if (currentFragment != null) {
            // lets see if the currentFragment or any of its childFragment can handle onBackPressed
            return currentFragment.onBackPressed();
        }

        // this Fragment couldn't handle the onBackPressed call
        return false;
    }*/

}
