package com.example.lalit.lalitdev.DemoFunctionality.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lalit.lalitdev.R;

/**
 * Created by Admin on 12/8/2017.
 */

public class CashEqulityFragment extends Fragment {
    View rootView;
    LinearLayout linearLayoutCash;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_cash_equivalent_layout, null);
        initViews();
        return rootView;
    }
    public void initViews(){
        linearLayoutCash=(LinearLayout)rootView.findViewById(R.id.layoutCash);
        linearLayoutCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CashEquivalentDetailsFragment fragment2 = new CashEquivalentDetailsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment2);
                fragmentTransaction.commit();
            }
        });
    }
}
