package core.component;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by ary on 4/18/17.
 */

public class FontManager {

    public static final String FONTAWESOME = "fonts/fontawesome-webfont.ttf";

    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }

    public static void useFontAwesome(TextView v) {
        v.setTypeface(FontManager.getTypeface(v.getContext(), FontManager.FONTAWESOME));
    }
}
