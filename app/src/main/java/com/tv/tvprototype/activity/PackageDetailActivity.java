package com.tv.tvprototype.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.component.FontManager;
import core.event.MessageEvent;
import core.fragment.PackageFragment;

/**
 * Created by ary on 4/7/17.
 */

public class PackageDetailActivity extends BaseAppCompatActivity {
    @BindView(R.id.buy_button)
    Button buyButton;

    private ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Day 1", "Day 2", "Day 3"));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_detail);
        ButterKnife.bind(this);

        FontManager.useFontAwesome(buyButton);


        getSupportActionBar().setTitle(R.string.package_detail_title);

        showFragment(new PackageFragment(titles, getSupportFragmentManager()));

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEventBus().post(new MessageEvent("Hello everyone!"));
                Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

}
