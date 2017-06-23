package core.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import core.fragment.PackageCitySlideFragment;

/**
 * Created by ary on 5/4/17.
 */

public class ItemPackageCityPagerAdapter extends FragmentStatePagerAdapter {
    private FragmentManager fm;

    public ItemPackageCityPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new PackageCitySlideFragment(position);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public float getPageWidth(int position) {
        return (0.5f);
    }
}
