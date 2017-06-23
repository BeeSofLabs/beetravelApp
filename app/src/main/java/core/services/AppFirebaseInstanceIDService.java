package core.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by ary on 5/19/17.
 */

public class AppFirebaseInstanceIDService extends FirebaseInstanceIdService {
//    private static final String TAG = "AppFirebaseInstanceIDService";

    public static AppFirebaseInstanceIDService getInstance() {
        return new AppFirebaseInstanceIDService();
    }

    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TAG", "New Token = " + token);
    }
}
