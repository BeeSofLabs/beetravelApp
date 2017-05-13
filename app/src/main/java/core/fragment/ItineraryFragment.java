package core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.ItemItineraryCardAdapter;

/**
 * Created by ary on 5/4/17.
 */

public class ItineraryFragment extends Fragment {
    @BindView(R.id.image_package)
    ImageView imagePackage;
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
        pager.setClipToPadding(false);
        pager.setPadding(40, 0, 40, 0);
        pager.setPageMargin(5);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(">>>POS=", position+"");
                if((position % 2) == 0 )
                    imagePackage.setImageResource(R.drawable.sanur_bali_resort);
                else
                    imagePackage.setImageResource(R.drawable.beach_resort);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return rootView;
    }
}
