package core.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import core.fragment.ItinerarySlideFragment;

/**
 * Created by ary on 5/4/17.
 */

public class ItemItineraryCardAdapter extends FragmentStatePagerAdapter {
    private FragmentManager fm;

    public ItemItineraryCardAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ItinerarySlideFragment(position);
    }

    @Override
    public int getCount() {
        return 10;
    }
}
