package com.tv.tvprototype.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.event.MessageEvent;
import core.fragment.AccountFragment;
import core.fragment.HomeFragment;
import core.fragment.OrderFragment;

public class MainActivity extends BaseAppCompatActivity {
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
//    @BindView(R.id.progressBar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle(R.string.main_title);

        showFragment(new HomeFragment(getSupportFragmentManager()));

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        runThread();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    runThread();
//                    progressBar.setProgress(20);
                    showFragment(new HomeFragment(MainActivity.this.getSupportFragmentManager()));

                    return true;
                case R.id.navigation_orders:
//                    runThread();
//                    progressBar.setProgress(80);
//                    mTextMessage.setText(R.string.title_dashboard);
//                    intent = new Intent(getApplicationContext(), PackageActivity.class);
//                    startActivity(intent);
                    showFragment(new OrderFragment());
                    return true;
                case R.id.navigation_account:
//                    runThread();
//                    progressBar.setProgress(100);
                    showFragment(new AccountFragment());
                    getEventBus().post(new MessageEvent("Welcome from main activity said!!"));
                    return true;
            }
            return false;
        }

    };

//    protected void runThread(){
//        progressBar.setProgress(0);
//
//
//        final int totalProgressTime = 100;
//
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                int jumpTime = 0;
//
//                while(jumpTime < totalProgressTime) {
//                    try {
//                        Thread.sleep(200);
//                        jumpTime += 5;
//                        progressBar.setProgress(jumpTime);
//
//                        Log.d("", " ---- call run ui thread");
//
//                        if(jumpTime == 100) progressBar.setVisibility(View.INVISIBLE);
//                        else progressBar.setVisibility(View.VISIBLE);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//
//    }

}
