package com.devlopment.software.demo.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ForegroundLinearLayout extends LinearLayout {


    public ForegroundLinearLayout(Context context) {
        super(context);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        // 用颜色覆盖整个画布
        canvas.drawColor(Color.parseColor("#50FF0000"));
    }
}
