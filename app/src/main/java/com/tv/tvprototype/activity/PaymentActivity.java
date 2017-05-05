package com.tv.tvprototype.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.fragment.PackageFragment;
import core.fragment.PaymentStepOneFragment;
import core.fragment.PaymentStepThreeFragment;
import core.fragment.PaymentStepTwoFragment;

/**
 * Created by ary on 4/7/17.
 */

public class PaymentActivity extends BaseAppCompatActivity{
    @BindView(R.id.toolbar_payment)
    Toolbar toolbar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    private int indexPanel = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switch (indexPanel) {
            case 0:
                showFragment(new PaymentStepOneFragment());
                break;

            case 1:
                showFragment(new PaymentStepTwoFragment());
                break;

            case 2:
                showFragment(new PaymentStepThreeFragment());
                break;

            default:
                showFragment(new PaymentStepOneFragment());
                break;
        }


    }

}
