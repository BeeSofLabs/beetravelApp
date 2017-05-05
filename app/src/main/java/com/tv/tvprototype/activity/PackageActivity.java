package com.tv.tvprototype.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import core.fragment.ListPackageFragment;

/**
 * Created by ary on 4/7/17.
 */

public class PackageActivity extends BaseAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        getSupportActionBar().setTitle(R.string.package_title);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        showFragment(new ListPackageFragment());
    }


}
