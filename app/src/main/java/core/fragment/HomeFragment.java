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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.ItemBannerCardPagerAdapter;
import core.adapter.ItemPackageCityPagerAdapter;
import core.component.CustomViewPager;
import core.util.ScreenUtil;

/**
 * Created by ary on 5/19/17.
 */

public class HomeFragment extends Fragment {
    @BindView(R.id.pager_banner)
    ViewPager pagerBanner;

    @BindView(R.id.pager_popular1)
    ViewPager pagerPopular1;
    @BindView(R.id.pager_popular2)
    ViewPager pagerPopular2;

    @BindView(R.id.search_layout)
    LinearLayout searchLayout;

    @BindView(R.id.search_keyword)
    TextView searchKeyword;

    private FragmentManager fragmentManager;

    public HomeFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        pagerBanner.setAdapter(new ItemBannerCardPagerAdapter(this.fragmentManager));
        pagerBanner.setClipToPadding(false);
        pagerBanner.setPageMargin(5);


        pagerPopular1.setAdapter(new ItemPackageCityPagerAdapter(this.fragmentManager));
        pagerPopular1.setClipToPadding(false);

        pagerPopular2.setAdapter(new ItemPackageCityPagerAdapter(this.fragmentManager));
        pagerPopular2.setClipToPadding(false);

        searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("","-------  click search layout");
            }
        });


        return rootView;
    }
}
