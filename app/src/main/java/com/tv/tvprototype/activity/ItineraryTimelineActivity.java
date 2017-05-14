package com.tv.tvprototype.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.fragment.ListItineraryFragment;

/**
 * Created by ary on 5/14/17.
 */

public class ItineraryTimelineActivity extends BaseAppCompatActivity {
    @BindView(R.id.toolbar_itinerary)
    Toolbar toolbarItinerary;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_timeline);
        ButterKnife.bind(this);

        setSupportActionBar(toolbarItinerary);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showFragment(new ListItineraryFragment());


    }
}
