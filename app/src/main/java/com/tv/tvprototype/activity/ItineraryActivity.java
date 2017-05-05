package com.tv.tvprototype.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.fragment.ItineraryFragment;

/**
 * Created by ary on 4/7/17.
 */

public class ItineraryActivity extends BaseAppCompatActivity {
    @BindView(R.id.toolbar_itinerary)
    Toolbar toolbarItinerary;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);
        ButterKnife.bind(this);

        setSupportActionBar(toolbarItinerary);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showFragment(new ItineraryFragment(getSupportFragmentManager()));
    }
}
