package guokangjie.news.com.weiying.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by 郭康杰 on 2017/12/15.
 */

public class MyFrameLayout extends FrameLayout {
    private MyMainDragView dl;

    public MyFrameLayout(Context context) {
        super(context);
    }

    public MyFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setDragLayout(MyMainDragView dl) {
        this.dl = dl;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (dl.getStatus() != MyMainDragView.Status.Close) {
            return true;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (dl.getStatus() != MyMainDragView.Status.Close) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                dl.close();
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

}