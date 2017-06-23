package core.component;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ary on 6/21/17.
 */

public class CustomViewPager extends ViewPager {

    private int mPrevMoveX;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs, int mPrevMoveX) {
        super(context, attrs);
        this.mPrevMoveX = mPrevMoveX;
    }

    //    @Override
//    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
//        if(v instanceof ViewPager) {
//            return true;
//        }
//        return super.canScroll(v, checkV, dx, x, y);
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                mPrevMoveX = (int) event.getX();

                return super.onTouchEvent(event);

            case MotionEvent.ACTION_MOVE:
                int distanceX = mPrevMoveX - (int) event.getX();
                mPrevMoveX = (int) event.getX();

                boolean canScrollLeft = true;
                boolean canScrollRight = true;

                if(getCurrentItem() == getAdapter().getCount() - 1)
                {
                    canScrollLeft = false;
                }

                if(getCurrentItem() == 0)
                {
                    canScrollRight = false;
                }

                if(distanceX > 0)
                {
                    return canScrollRight;
                }
                else
                {
                    return canScrollLeft;
                }
        }

        return super.onInterceptTouchEvent(event);
    }
}
