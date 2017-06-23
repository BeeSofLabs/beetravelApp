package com.tv.tvprototype.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.fragment.ListPackageFragment;

/**
 * Created by ary on 4/7/17.
 */

public class PackageActivity extends BaseAppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.package_title);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showFragment(new ListPackageFragment());
    }


}
