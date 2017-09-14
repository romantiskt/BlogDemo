package com.wang.advance.widget.low;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wangyang on 2017/9/14.
 */

public class CircleView extends View {
    public CircleView(Context context) {
        this(context,null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);

    }
    Paint mPaint;
    int width;
    int heigh;
    int arcWidth;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width=getWidth();
        heigh=getHeight();
        int x=width/2;
        int y=heigh/2;
        int startAngle=-45;
        RectF rect=new RectF(x-150,y-150,x+150,y+150);
        canvas.drawArc(rect,startAngle,45,true,mPaint);
        startAngle=startAngle+45;

        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rect,startAngle,25,true,mPaint);
        startAngle=startAngle+25;

        mPaint.setColor(Color.GRAY);
        canvas.drawArc(rect,startAngle,15,true,mPaint);
        startAngle=startAngle+15;

        mPaint.setColor(Color.GREEN);
        canvas.drawArc(rect,startAngle,40,true,mPaint);
        startAngle=startAngle+40;

        mPaint.setColor(Color.CYAN);
        x-=5;
        RectF rect2=new RectF(x-150,y-150,x+150,y+150);
        canvas.drawArc(rect2,startAngle,90,true,mPaint);
        startAngle=startAngle+90;

        x-=5;
        y-=15;
        mPaint.setColor(Color.LTGRAY);
        RectF rect3=new RectF(x-150,y-150,x+150,y+150);
        canvas.drawArc(rect3,startAngle,360-45-startAngle,true,mPaint);


    }
}
