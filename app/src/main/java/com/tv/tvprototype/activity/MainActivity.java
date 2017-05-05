package com.tv.tvprototype.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.crashlytics.android.Crashlytics;
import com.tv.tvprototype.BaseAppCompatActivity;
import com.tv.tvprototype.R;

import org.greenrobot.eventbus.EventBus;

import core.event.MessageEvent;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends BaseAppCompatActivity {

    @BindView(R.id.message)
    TextView mTextMessage;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
//    @BindView(R.id.progressBar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(R.string.main_title);

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
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_packages:
//                    runThread();
//                    progressBar.setProgress(80);
//                    mTextMessage.setText(R.string.title_dashboard);
                    intent = new Intent(getApplicationContext(), PackageActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
//                    runThread();
//                    progressBar.setProgress(100);
                    mTextMessage.setText(R.string.title_notifications);
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
