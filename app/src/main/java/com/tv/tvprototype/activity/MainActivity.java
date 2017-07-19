package com.tv.tvprototype.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.fragment.HomeFragment;
import core.fragment.OrderFragment;

public class MainActivity extends BaseAppCompatActivity {
    @BindView(R.id.navigation)
    BottomNavigationView navigation;


//    @BindView(R.id.hidden_panel)
//    RelativeLayout hiddenPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        showFragment(new HomeFragment(getSupportFragmentManager()));

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(new HomeFragment(MainActivity.this.getSupportFragmentManager()));

                    return true;
                case R.id.navigation_orders:
                    showFragment(new OrderFragment());
                    return true;
                case R.id.navigation_account:
//                    showFragment(new AccountFragment());
//                    getEventBus().post(new MessageEvent("Welcome from main activity said!!"));
//                    Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(),
//                            R.anim.bottom_up);
//                    hiddenPanel.startAnimation(bottomUp);
//                    hiddenPanel.setVisibility(View.VISIBLE);

                    overridePendingTransition(R.anim.anim_slide_out_bottom, R.anim.anim_slide_in_top);
                    startActivity(new Intent(getBaseContext(), SearchFilterActivity.class));
                    return true;
            }
            return false;
        }

    };
}
