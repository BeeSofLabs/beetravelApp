package core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.tv.tvprototype.R;
import com.tv.tvprototype.activity.PackageDetailActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.TabPagerAdapter;

/**
 * Created by ary on 4/15/17.
 */

public class PackageFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.tabs)
    SmartTabLayout tabs;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.add_day)
    Button addDayButton;

    private ArrayList<String> titles;
    private FragmentManager fragmentManager;

    public PackageFragment(ArrayList<String> titles, FragmentManager fragmentManager) {
        this.titles = titles;
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tabs_days, container, false);
        ButterKnife.bind(this, rootView);
        Log.d("", "create view of itinerary fragment");
        // Initialize the ViewPager and set an adapter
        pager.setAdapter(new TabPagerAdapter(this.titles, this.fragmentManager));

        // Bind the tabs to the ViewPager
        tabs.setViewPager(pager);
//        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        addDayButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        Log.d("TAG", "click add day button!");
        titles.add("Day " + (this.titles.size() + 1));
        ((PackageDetailActivity) getActivity()).showFragment(new PackageFragment(titles, fragmentManager));

//        Intent intent = new Intent(getActivity(), PackageDetailActivity.class);
//        getActivity().startActivity(intent);
//        getActivity().finish();=

    }

}
