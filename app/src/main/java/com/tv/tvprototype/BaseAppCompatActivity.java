package com.tv.tvprototype;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.widget.AppCompatButton;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import core.event.MessageEvent;


/**
 * Created by ary on 4/14/17.
 */

public class BaseAppCompatActivity extends AppCompatActivity {
    int onStartCount = 0;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        onStartCount = 1;
//        if (savedInstanceState == null) // 1st time
//        {
//            this.overridePendingTransition(R.anim.anim_slide_in_left,
//                    R.anim.anim_slide_out_left);
//        } else // already created so reverse animation
//        {
//            onStartCount = 2;
//        }
//    }

//    @Override
//    protected void onStart() {
//        // TODO Auto-generated method stub
//        super.onStart();
//        if (onStartCount > 1) {
//            this.overridePendingTransition(R.anim.anim_slide_in_right,
//                    R.anim.anim_slide_out_right);
//
//        } else if (onStartCount == 1) {
//            onStartCount++;
//        }
//
//    }


    public void showFragment(Fragment fragment) {

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.detach(fragment);
            fragmentTransaction.attach(fragment);
            fragmentTransaction.commit();
        }
    }

    protected EventBus getEventBus(){
        return EventBus.getDefault();
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEvent(MessageEvent event){
        Toast.makeText(this, event.message, Toast.LENGTH_LONG).show();
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        getEventBus().register(this);
//    }

    @Override
    protected void onStop() {
        getEventBus().unregister(this);
        super.onStop();
    }




}
