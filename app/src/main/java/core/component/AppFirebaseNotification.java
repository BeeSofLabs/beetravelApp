package core.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tv.tvprototype.activity.MainActivity;

import core.services.AppFirebaseMessageService;

/**
 * Created by ary on 5/18/17.
 */

public class AppFirebaseNotification {
    private Context context;
    private Activity activity;


    public AppFirebaseNotification(Context context) {
        this.context = context;
    }

    public static AppFirebaseNotification getInstance(Context context){
        return new AppFirebaseNotification(context);
    }

    public String getToken() {
        return FirebaseInstanceId.getInstance().getToken();
    }

    public void sendNotif(String body) {

        AppFirebaseMessageService.sendNotification(this.context, body);
    }
}
