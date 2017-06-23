package core.util;

import android.content.res.Resources;

/**
 * Created by ary on 5/20/17.
 */

public class ScreenUtil {

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
