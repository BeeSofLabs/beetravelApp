package com.tv.tvprototype.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 6/30/17.
 */

public class SearchFilterActivity extends BaseAppCompatActivity {
    @BindView(R.id.cancel_action)
    ImageView cancelAction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filter);
        ButterKnife.bind(this);

        cancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}
