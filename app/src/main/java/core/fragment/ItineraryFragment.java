package core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.ItemItineraryCardAdapter;

/**
 * Created by ary on 5/4/17.
 */

public class ItineraryFragment extends Fragment {
    @BindView(R.id.pager)
    ViewPager pager;

    @BindView(R.id.pagerDots)
    TabLayout pagerDots;

    private FragmentManager fragmentManager;

    public ItineraryFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_itinerary, container, false);
        ButterKnife.bind(this, rootView);

//        // Initialize the ViewPager and set an adapter
        pager.setAdapter(new ItemItineraryCardAdapter(this.fragmentManager));
        pagerDots.setupWithViewPager(pager, true);
//        pager.setClipToPadding(false);
//        pager.setPadding(40, 0, 40, 0);
//        pager.setPageMargin(5);

        return rootView;
    }
}
