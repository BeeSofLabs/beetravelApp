package core.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import core.fragment.BannerSlideFragment;

/**
 * Created by ary on 5/4/17.
 */

public class ItemBannerCardPagerAdapter extends FragmentStatePagerAdapter {
    private FragmentManager fm;

    public ItemBannerCardPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new BannerSlideFragment(position);
    }

    @Override
    public int getCount() {
        return 10;
    }


}
